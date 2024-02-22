package day3;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class cookiesDemo {
	
	//@Test (priority=1)
	void testCookies()
	{
		given()
		
		.when()
			.get("https://www.google.co.in/")
			
		.then()
			.cookie("AEC","Ae3NU9OzBTNzuWq6lilkNEdmV2BtYPIZUGc3WhFSJ7pIRVw-AGlynC50qc4")
			.log().all();
		
	}
	
	@Test(priority=2)
	void getCookiesInfo()
	{
		Response res=given()
		
		.when()
			.get("https://www.google.co.in/");
		
		//get single cookies information
		String Cookies1_Value=res.getCookie("AEC");
		System.out.println("The Value of Cookie is :"+Cookies1_Value);
		
		//get all cookies information
		Map<String,String> all_Coookies=res.getCookies();
		
		//Print only keys statmente
		System.out.println(all_Coookies.keySet());
		
		for(String k:all_Coookies.keySet())
		{
			String single_cookie_value=res.getCookie(k);
			System.out.println(k+"     "+single_cookie_value);
		}
			
		
		
	}

}
