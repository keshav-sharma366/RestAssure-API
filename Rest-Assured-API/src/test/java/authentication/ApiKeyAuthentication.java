package authentication;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
public class ApiKeyAuthentication {
	@Test(priority=1)
	void testAPIKeyAuthentication()

	{
		//method 1
		given()
		    .queryParam("appid","fe9c5cddb7e01d747b4611c3fc9eaf2c") //appid is APIKey
		.when()
		    .get("https://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=metric&cnt=7")
		.then()
		    .statusCode(200)
		    .log().all();

	}
	@Test(priority=2)
	void testAPIKeyAuthenticationMethod2()

	{
		//Method2

		given()
		    .queryParam("appid","fe9c5cddb7e01d747b4611c3fc9eaf2c")

		    .pathParam("mypath","data/2.5/forecast/daily")

		    .queryParam("q", "Delhi")

		    .queryParam("units", "metric")

		    .queryParam("cnt", "7")

		.when()
		    .get("https://api.openweathermap.org/{mypath}")

		.then()
		    .statusCode(200)
		    .log().all();

	}


}
