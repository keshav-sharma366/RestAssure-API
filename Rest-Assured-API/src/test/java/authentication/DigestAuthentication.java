package authentication;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class DigestAuthentication {
	@Test(priority=0)
	void testDigestAuthentication()

	{
		given()
		    .auth().digest("postman","password")
		.when()
		    .get("https://postman-echo.com/basic-auth")

		.then()
		    .statusCode(200)
		    .body("authenticated",equalTo(true))
		    .log().all();

	}

}
