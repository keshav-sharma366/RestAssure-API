package parseJsonresponse;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class ParseJsonResponse {
	@Test 
	void testJsonResponse()
	{
		//approach 1
		given()
		.contentType("ContentType.JSON")
		
		.when()
		.get("http://localhost:3000/students")
		
		.then()
		.statusCode(200)
		.header("content-type","application/json; charset=utf-8")
		.body("find{it.id==202}.email",equalTo("student2@example.com"));
		
	}
	

}
