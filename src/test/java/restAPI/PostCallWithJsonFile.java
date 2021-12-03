package restAPI;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostCallWithJsonFile {
	
	@Test
	public void PostCall() throws IOException {
		
		RestAssured.baseURI = "http://localhost:7000";
			
		RequestSpecification request =  RestAssured.given();
			
		String JsonBody = ReadJsonFile("data.json");
			
		Response response = request.contentType(ContentType.JSON)
					                    .accept(ContentType.JSON)
					                    .body(JsonBody)
					                    .post("/employees/create");
		
		String ResponseBody = response.body().asString();
		
		System.out.println(ResponseBody);
		
		int ActResponse = response.statusCode();
		int Expresponse = 201;
		
		AssertJUnit.assertEquals(ActResponse,  Expresponse);
		
		JsonPath jpath = response.jsonPath();
		String ActName = jpath.get("name");
		String ExpName = "James";
		
		AssertJUnit.assertEquals(ActName,  ExpName);
	}
	
	public String ReadJsonFile(String FileName) throws IOException {
		
		String data = new String(Files.readAllBytes(Paths.get(FileName)));
		
		return data;
		
	}
}