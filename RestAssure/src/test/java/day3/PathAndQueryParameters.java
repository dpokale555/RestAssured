package day3;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;


public class PathAndQueryParameters {
	
	//https://reqres.in/api/users?page=2&id=5
	
	@Test
	void testPathAndQueryParameters()
	{

		given()
		.pathParam("mypath","users")  //path parameter
		.queryParam("page",2)         //query parameter
		.queryParam("id",5)           //query parameter
		
		.when()
			.get("https://reqres.in/api/{mypath}")
		
		.then()
			.statusCode(200)
			.log().all();
	}

}
