package day3;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersDemo {
	
	//@Test
	void testHeader()
	{
		given()
		.when()
			.get("https://www.google.co.in/")
			
		.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.header("Content-Encoding", "gzip")
			.header("Server", "gws");
			
			
	}
	
	
	@Test
	void getHeaders()
	{
		Response resp=given()
		.when()
			.get("https://www.google.co.in/");
		
		//get single header info
		String Header1_value=resp.getHeader("Content-Type");
		System.out.println("Single header value :"+Header1_value);
		
		//get all headers info
		Headers all_hearders=resp.getHeaders();
		
		for(Header hd:all_hearders)
		{
		System.out.println(hd.getName()+"        "+hd.getValue());
		}
		
		
		
			
			
	}

}
