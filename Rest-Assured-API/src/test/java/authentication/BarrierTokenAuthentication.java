package authentication;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class BarrierTokenAuthentication {
	@Test(priority=0)
	void testBearerTokenAuthentication()

	{
		String bearerToken="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";

		given()
		    .headers("Authorization","Bearer "+bearerToken)

		.when()
		    .get("https://api.github.com/user/repos")

		.then()
		    .statusCode(200)
		    .log().all();

	}

}
