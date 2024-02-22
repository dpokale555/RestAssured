package day3;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class LoggingDemo {
	
	@Test (priority=1)
	void testLog()
	{
		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
		//.log().all();    //used .all() if want to print everything
		//.log().body();   //used only to print body
		//.log().cookies();  //used only to print cookies
		.log().headers();    //used only to print headers
	}

}
