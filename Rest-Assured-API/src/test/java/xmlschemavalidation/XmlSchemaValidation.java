package xmlschemavalidation;

//For given(), when(), then(), get(), post(), etc.
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*; // xml validation ke liye h

//For validation matchers like equalTo(), hasItems(), contains(), etc.
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;

public class XmlSchemaValidation {
	
	// to convert xml response to schema site is here https://www.site24x7.com/tools/xml-to-xsd.html
	@Test
	void xmlSchemavalidation()
	{
	    given()

	    .when()
	        .get("http://localhost:8000/studentsXML.xml")
	    .then()
	    		
	        .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("xmlschema.xsd"));

	}

}
