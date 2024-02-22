package day1;

//We have to import this packages manually from rest assured doc website
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

/*
given()
	content type, set cookies, add auth, add parameters, set header info etc..

when()
	types of request: get, post, put, delete etc..
	
then()
	Validate status code, extarct responsed, extract headers, cookies & responsed body...
*/

/*
 * //Get req : Get Users
		https://reqres.in/api/users?page=2

	//Post req : Create new user
			https://reqres.in/api/users
				
			{
			    "name": "morpheus",
			    "job": "leader"
			}
	//put req : Update new user
		https://reqres.in/api/users/2
			
		{
		    "name": "morpheus",
		    "job": "zion resident"
		}
		
		//delete req
		https://reqres.in/api/users/2
 */

public class HTTP_Request {
	
	int id;
	
	//1) ************Get req : Get Users**************
	@Test(priority=1)
	void getUsers()
	{
		given()
		   		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.statusCode(200)
			.body("page",equalTo(2))
			.log().all();
	}
	
	//2)**************Post req : Create new user***************
	@Test(priority=2)
	void createUser()
	{
		HashMap data=new HashMap();
		data.put("name","Pavan");
		data.put("job","trainer");
		
	given()
		.contentType("application/json")
		.body(data)
		
	.when()
		.post("https://reqres.in/api/users")
		
	.then()
		.statusCode(201)
		.log().all();
	}
	
	
	//3)***********put req : Update new user*****************
	
	@Test(priority=3)
	void createUser2()
	{
		HashMap data=new HashMap();
		data.put("name","Ram");
		data.put("job","Coach");
		
	id=given()
		.contentType("application/json")
		.body(data)
		
	.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");	
	}
	
	@Test(priority=4, dependsOnMethods= {"createUser2"})
	void updateUser()
	{
		HashMap data=new HashMap();
		data.put("name","Karan");
		data.put("job","Student");
		
		given()
				.contentType("application/json")
				.body(data)
				
		.when()
				.put("https://reqres.in/api/users/"+id)	
			
		.then()
			.statusCode(200)
			.log().all();	
	}
	
	
	//4)************delete req****************
	
	@Test(priority=5)
	void deleteUser()
	{
		given()
		
		.when()
			.delete("https://reqres.in/api/users/"+id)
			
		.then()
			.statusCode(204)
			.log().all();
	}
	

}
