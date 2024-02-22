package day5_ParsingXML_Response_Data;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ParsingXML_Validation {
	
	@Test (priority=1)
	void testXMLResponsebody1()
	{
		Response resp=given()
		
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1");
			
		XmlPath xmlobj=new XmlPath(resp.asString());
		
		//Requirmemt 1: To find total numbers of travelers
		List<String> traveles_list=xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation");	
		Assert.assertEquals(traveles_list.size(),10);
		
		
		//To verify if any tarveler names is present or not
		List<String> travele_namelist=xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		
		boolean status=false;
		for(String traveler_name:travele_namelist)
		{
			System.out.println(traveler_name);
			
			if(traveler_name.equals("Ashor"))
			{
				
				status=true;
				break;
			}
			
		}
		
		Assert.assertEquals(status, true);
		
	}


}
