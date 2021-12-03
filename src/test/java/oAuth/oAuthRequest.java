package oAuth;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class oAuthRequest {
	
	@Test
	public void PostCall() {
		
		RestAssured.given()
	             	.auth()
		            .oauth2("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")
		            .baseUri("https://api.github.com")
		            .contentType(ContentType.JSON)
		            .accept(ContentType.JSON)
		            .body("{\n" +
		                   " \"name\": \"PostmanTest\",\n" +
		                   " \"desription\": \"Test Repo\", \n" +
		                   " \"homepage\": \"https://github.com/\", \n" +
		                   " \"private\": false, \n" +
		                   " \"has_issues\": true, \n" +
		                   " \"has_project\": true, \n" +
		                   " \"has_wiki\": true\n" +
		                   "}")
	            	.when()
		            .post("/user/repos")
		            .then()
		    		.statusCode(201)
		    		.log()
		    		.all();

	}

}
