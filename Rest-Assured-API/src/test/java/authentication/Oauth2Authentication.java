package authentication;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class Oauth2Authentication {
	@Test
	void testOAuth2Authentication()

	{
		given()
		    .auth().oauth2("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")
		.when()
		    .get("https://api.github.com/user/repos")
		.then()
		    .statusCode(200)
		    .log().all();

	}

}
