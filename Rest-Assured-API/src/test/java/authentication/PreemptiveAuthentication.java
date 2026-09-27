package authentication;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class PreemptiveAuthentication {
	@Test(priority=1)
	void testPreempiveAuthentication()

	{
		given()
		    .auth().preemptive().basic("postman","password")
		.when()
		    .get("https://postman-echo.com/basic-auth")

		.then()
		    .statusCode(200)
		    .body("authenticated",equalTo(true))
		    .log().all();

	}

}
