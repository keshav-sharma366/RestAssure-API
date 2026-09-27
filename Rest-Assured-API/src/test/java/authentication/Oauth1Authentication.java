package authentication;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
public class Oauth1Authentication {
	@Test
	void testOAuth1Authentication()

	{
		given()
		    .auth().oauth("consumerKey","consumerSecrat","accessToken","tokenSecrate")
		.when()
		    .get("url")
		.then()
		    .statusCode(200)
		    .log().all();

	}

}
