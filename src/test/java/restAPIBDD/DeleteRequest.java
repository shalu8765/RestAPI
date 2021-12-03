package restAPIBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteRequest {
	
	@Test
	public void Deletecall() {
		
		RestAssured.given()
				   .baseUri("http://localhost:7000")
				   .when()
				   .delete("/employees/11")
				   .then()
				   .statusCode(200);
	}
}