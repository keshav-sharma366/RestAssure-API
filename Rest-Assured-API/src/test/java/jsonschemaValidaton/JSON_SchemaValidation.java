package jsonschemaValidaton;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

//https://transform.tools/json-to-json-schema
public class JSON_SchemaValidation {
	@Test
	void jsonschemavalidation()
	{
	    given()

	    .when()
	        .get("http://localhost:3000/books")
	    .then()
	        .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonschema.json"));

	}

}
