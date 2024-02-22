package day4_Valiudate_Response_Data;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJSON_Validation {
	
	

	//To validate the response body data
	//To capture the titles from each object and check if perticular title is present or not
	
	@Test(priority=1)
		void testJsonResponseBodyData()
		{
			
		Response resp=given()
				.contentType(ContentType.JSON)
			
			.when()
				.get("http://localhost:3000/storeData");
	
		//we need to used JSON Object class
		JSONObject jo=new JSONObject(resp.asString());     //pls used .asString() insted of .toString()
		
	
		//Requirement 1:Validate the title 
		
		boolean status1=false;
		
		for(int i=0;i<jo.getJSONArray("book").length();i++)
		{
		String bookTitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
		System.out.println(bookTitle);
		
		if(bookTitle.equals("Long Distance"))
		{
			status1=true;
			break;
			
		}
		
		}
		
		Assert.assertEquals(status1, true);
		
		
		
		//Requirement 2:validate the price and capture the total price of the books
			
		double total_prc=0;
				
		for(int i=0;i<jo.getJSONArray("book").length();i++)
			{
				String bookPrice=jo.getJSONArray("book").getJSONObject(i).get("price").toString();
				total_prc=total_prc+Double.parseDouble(bookPrice);
				
			}
			
		System.out.println("Total Price of books :"+total_prc);
		Assert.assertEquals(total_prc, 1588.97);
				
	}

}
