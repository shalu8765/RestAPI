package restAPI;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	
	@Test
	public void PostCall() {


	RestAssured.baseURI = "http://localhost:7000";

	RequestSpecification request = RestAssured.given();

	Response response = request.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	.body("{\n" +
	" \"name\": \"XYZ\",\n" +
	" \"salary\": \"15000\"\n" +
	"}").post("/employees/create");

	String ResponseBody =response.body().asString();
	System.out.println(ResponseBody);

	int ActResponse = response.getStatusCode();
	int expectedResponse = 201;

	AssertJUnit.assertEquals(ActResponse, expectedResponse);
	}

}
