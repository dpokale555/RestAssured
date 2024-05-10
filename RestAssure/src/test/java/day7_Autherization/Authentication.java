package day7_Autherization;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

public class Authentication {
	
	@Test
	void testBasic_authentication()
	{
		given()
			.auth().basic("postman", "password")
			
		.when()
			.get("https://postman-echo.com/basic-auth")
			
		.then()
			.statusCode(200)
			.body(null, null);
	}

}
