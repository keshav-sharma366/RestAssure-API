package xmlresponsevalidation;
//For given(), when(), then(), get(), post(), etc.
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*; // xml validation ke liye h

//For validation matchers like equalTo(), hasItems(), contains(), etc.
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ValidateResponseXML {
	@Test(priority=1)
	public void testXmlResponseApproach1()
	{
		//Approach1

		given()

		.when()
		    .get("http://restapi.adequateshop.com/api/Traveler?page=1")
		.then()
		    .statusCode(200)
		    .header("Content-Type","application/xml; charset=utf-8")
		    .body("TravelerinformationResponse.page", equalTo("1"))
		    .body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Vijay Bharath"));

	}
	@Test(priority=2)
	public void testResponseApproach2()
	{
		//Approach2

		Response res=
		given()

		.when()
		    .get("http://restapi.adequateshop.com/api/Traveler?page=1");

		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"),"application/xml; charset=utf-8");

		String pageNo=res.xmlPath().get("TravelerinformationResponse.page").toString();
		Assert.assertEquals(pageNo, "1");

		String travelName=res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
		Assert.assertEquals(travelName, "Vijay Bharath Reddy");
	}

}