package day5_ParsingXML_Response_Data;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.testng.annotations.Test;

public class FileUploadAndDownload {
	
	//@Test(priority=1)
	void SingleFileUpload()
	{
		File myfile=new File("C:\\Users\\dhananjay.pokale\\Desktop\\test_data.xlsx");
		
		given()
			.multiPart("File",myfile)
			.contentType("multipart/form-data")
			
		.when()
			.post("http://localhost:8080/uploadFile")
			
		.then()
			.statusCode(200)
			.body("filename",equalTo("test_data.xlsx"))
			.log().all();
	}
	
	
	@Test(priority=2)
	void MultiFilesUpload()
	{
		File myfile1=new File("C:\\uploads\\test11.xls");
		File myfile2=new File("C:\\uploads\\test11.xls");
		
		//File FileArray[]= {myfile1,myfile2};
		
		given()
			.multiPart("files",myfile1)
			.multiPart("files",myfile2)
			//.multiPart("files",FileArray)
			.contentType("multipart/form-data")
			
		.when()
			.post("http://localhost:8080/uploadMultipleFiles")
			
		.then()
			.statusCode(200)
			.body("[0].filename",equalTo("test11.xls"))
			.body("[1].filename",equalTo("test11.xls"))
			.log().all();
	}
	
	@Test(priority=3)
	void DownloadFile()
	{
		given()
		
		.when()
			.get("http://localhost:8080/downloadFiles/test11.xls")
		.then()
			.statusCode(200)
			.log().all();
	}

}
