package day5_ParsingXML_Response_Data;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ParsingXML_Response {
	
	//Approach 1: Without returning the response in given()
	@Test (priority=1)
	void testXMLResponse1()
	{
		given()
		
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1")
			
		.then()
			.statusCode(200)
			.header("Content-Type","application/xml; charset=utf-8")
			.body("TravelerinformationResponse.page",equalTo("1"))
			.body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Developer"));
	}
	
	
	

	//Approach 2: returning and storing the response in given()
	@Test (priority=2)
	void testXMLResponse2()
	{
		Response resp=given()
		
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1");
			
		Assert.assertEquals(resp.getStatusCode(), 200);
		Assert.assertEquals(resp.header("Content-Type"),"application/xml; charset=utf-8");
		
		String Page_no1=resp.xmlPath().get("TravelerinformationResponse.page").toString();
		Assert.assertEquals(Page_no1, "1");
		
		String Page_no2=resp.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
		Assert.assertEquals(Page_no2, "Developer");
	}

}
