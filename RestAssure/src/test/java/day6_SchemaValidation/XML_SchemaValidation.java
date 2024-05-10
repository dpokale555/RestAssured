package day6_SchemaValidation;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;

public class XML_SchemaValidation {
	

	@Test (priority=1)
	void JsonSchemaValidation()
	{
		given()
		
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler")
			
		.then()
			.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("travler.xsd"));
	}

}
