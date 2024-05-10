package day6_SchemaValidation;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//Serilaization: POJO--->JSON Object
//Deserilazation: JSON objext----->POJO

public class SerilazationDeserilazation {
	
	@Test (priority=1)
	void convertPOJOtoJSON() throws JsonProcessingException
	{
		//Created the JAVA object using POJO class
		Students_POJO_PostRequest data=new Students_POJO_PostRequest();
		
		data.setId("1");
		data.setName("David");
		data.setLocation("India");
		data.setPhone("12344");
		String courseArry[]= {"C","Python","JAVA"};
		data.setCourses(courseArry);
		
		//convert JAVA object into JSON --> Serilization process
		ObjectMapper objMapper=new ObjectMapper();
		
		String jsonData=objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objMapper);
		
		System.out.println(jsonData);
		
	}
	
	
	@Test (priority=2)
	void convertJSONtoPOJO() throws JsonProcessingException
	{
		  String jsondata="{\r\n"
		  		+ "		      \"id\": \"2\",\r\n"
		  		+ "		      \"name\": \"Karan\",\r\n"
		  		+ "		      \"location\": \"Mumbai\",\r\n"
		  		+ "		      \"phone\": \"123345678\",\r\n"
		  		+ "		      \"courses\": [ \"JAVA\", \"C\"]\r\n"
		  		+ "		    }";
		  
		//convert JSON into JAVA object --> Deserilization process
			ObjectMapper StuMapper=new ObjectMapper();
			
			Students_POJO_PostRequest studPOJO=StuMapper.readValue(jsondata, Students_POJO_PostRequest.class);
		
			System.out.println("ID :"+studPOJO.getId());
			System.out.println("Name :"+studPOJO.getName());
			System.out.println("Phone :"+studPOJO.getPhone());
			System.out.println("Course 1 :"+studPOJO.getCourses()[0]);
			System.out.println("Course 2 :"+studPOJO.getCourses()[1]);
			
		
	}

}
