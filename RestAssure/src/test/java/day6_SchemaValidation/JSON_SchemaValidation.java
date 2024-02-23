package day6_SchemaValidation;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class JSON_SchemaValidation {
	
	@Test (priority=1)
	void JsonSchemaValidation()
	{
		given()
		
		.when()
			.get("http://localhost:3000/storeData")
			
		.then()
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storeDataSchema.json"));
	}
	
	

}
