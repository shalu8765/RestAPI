package restAPI;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
	
	
	@Test
	public void GetCall() {
		
		RestAssured.baseURI = "http://localhost:7000";
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.get("/employees");
		
		String ResponseBody = response.body().asString();
		
		System.out.println(ResponseBody);
	}

}
