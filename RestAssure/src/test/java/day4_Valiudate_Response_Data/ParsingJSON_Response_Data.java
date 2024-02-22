package day4_Valiudate_Response_Data;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJSON_Response_Data {
	
	//Approach 1 to validated the response with .then()
	//@Test(priority=1)
	void testJsonResponse1()
	{
		
		given()
			.contentType(ContentType.JSON)
		
		.when()
			.get("http://localhost:3000/storeData")
			
		.then()
			.statusCode(200)
			.header("Content-Type","application/json")
			.body("book[2].title", equalTo("Long Distance"))
			.body("book[1].category", equalTo("Romantic"));			
		
	}
	
	//Approach 2 to validate the response without .then()
	//It is most followed approach and used for complex json file
	//@Test(priority=2)
	void testJsonResponse2()
	{
		
	Response resp=given()
			.contentType(ContentType.JSON)
		
		.when()
			.get("http://localhost:3000/storeData");
	
	Assert.assertEquals(resp.getStatusCode(), 200);    //validation type 1
	Assert.assertEquals(resp.header("Content-Type"), "application/json");      //validation type 2
	
	String bookname=resp.jsonPath().get("book[2].title").toString();
	Assert.assertEquals(bookname, "Long Distance");
			
	}
	



}
