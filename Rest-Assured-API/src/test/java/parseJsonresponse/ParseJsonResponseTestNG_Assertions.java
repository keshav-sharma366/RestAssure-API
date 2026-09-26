package parseJsonresponse;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ParseJsonResponseTestNG_Assertions {
	@Test
	public void testRespone()
	{
		//approach 2
		Response res= given()
			    .contentType("ContentType.JSON")

			.when()
			    .get("http://localhost:3000/students");

			Assert.assertEquals(res.getStatusCode(),200);   //validation 1
			Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");

			String email=res.jsonPath().get("find{it.id==202}.email").toString();
			Assert.assertEquals(email,"student2@example.com");
	}

}
