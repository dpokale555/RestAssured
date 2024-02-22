package day2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class DiffrentWayToCreatePostRequestBody {
	
	
//Approch 1: POST req body using HashMap
	
	/*@Test(priority=1)
	void testPostUsing_HashMap()
	{
		//First Step: Prepare date HashMap
		HashMap data=new HashMap();
		
		data.put("id", "4");
		data.put("name", "David");
		data.put("location", "India");
		data.put("phone", "12323445");

		//Filed: courses has multiple value so wee need to create array and store all this value in this array
		String courseArry[]= {"C","Python","JAVA"};
		data.put("courses", courseArry);
		
		//Second Step: Pass the data
		given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.post("http://localhost:3000/students")
			
		.then()
			.statusCode(201)
			.body("name", equalTo("David"))
			.body("location", equalTo("India"))
			.body("courses[0]", equalTo("C"))
			.body("courses[1]", equalTo("Python"))
			.body("courses[2]", equalTo("JAVA"))
			.header("Content-Type", "application/json")
			.log().all();
				
	}*/
	
	

//Approch 2 :POST req body using org.json liblary
	
	/*	@Test(priority=1)
		void testPostUsing_JsonLiblary()
		{
			//First Step: Prepare date using org.json
			JSONObject data=new JSONObject();
			data.put("id", "4");
			data.put("name", "David");
			data.put("location", "India");
			data.put("phone", "12323445");

			//Filed: courses has multiple value so wee need to create array and store all this value in this array
			String courseArry[]= {"C","Python","JAVA"};
			data.put("courses", courseArry);
			
			//Second Step: Pass the data
			given()
				.contentType("application/json")
				.body(data.toString())          //here in org.json we can not pass 'data' directly we need to change it into string
				
			.when()
				.post("http://localhost:3000/students")
				
			.then()
				.statusCode(201)
				.body("name", equalTo("David"))
				.body("location", equalTo("India"))
				.body("courses[0]", equalTo("C"))
				.body("courses[1]", equalTo("Python"))
				.body("courses[2]", equalTo("JAVA"))
				.header("Content-Type", "application/json")
				.log().all();
					
		} */
	
		
//Approch 3 :POST req body using POJO Class (Plain Old Java Object)
	//For POJO have to create other class for setter and getter method
		
	/*		@Test(priority=1)
			void testPostUsing_POJO()
			{
				
				POJO_PostRequest data=new POJO_PostRequest();
				
				data.setId("4");
				data.setName("David");
				data.setLocation("India");
				data.setPhone("12344");

				//Filed: courses has multiple value so wee need to create array and store all this value in this array
				String courseArry[]= {"C","Python","JAVA"};
				data.setCourses(courseArry);
				
				//Second Step: Pass the data
				given()
					.contentType("application/json")
					.body(data)         
					
				.when()
					.post("http://localhost:3000/students")
					
				.then()
					.statusCode(201)
					.body("name", equalTo("David"))
					.body("location", equalTo("India"))
					.body("courses[0]", equalTo("C"))
					.body("courses[1]", equalTo("Python"))
					.body("courses[2]", equalTo("JAVA"))
					.header("Content-Type", "application/json")
					.log().all();
				} */
	
	//Approch 3 :POST req body using External json file 
		//For this create one json file in project ex: body.json
			
				@Test(priority=1)
				void testPostUsing_ExternalFile() throws FileNotFoundException
				{
					
					File f=new File(".\\body.json");
					
					FileReader fr=new FileReader(f);
					
					JSONTokener jt=new JSONTokener(fr);
					
					JSONObject data=new JSONObject(jt);
		
					
					//Second Step: Pass the data
					given()
						.contentType("application/json")
						.body(data.toString())         
						
					.when()
						.post("http://localhost:3000/students")
						
					.then()
						.statusCode(201)
						.body("name", equalTo("David"))
						.body("location", equalTo("India"))
						.body("courses[0]", equalTo("C"))
						.body("courses[1]", equalTo("Python"))
						.body("courses[2]", equalTo("JAVA"))
						.header("Content-Type", "application/json")
						.log().all();
					}
						
			
//Delete Request			
	
	@Test(priority=2)
	void deleteRecord()
	{
		
		given()
			
		.when()
			.delete("http://localhost:3000/students/4")
			
		.then()
			.statusCode(200);
	}

}
