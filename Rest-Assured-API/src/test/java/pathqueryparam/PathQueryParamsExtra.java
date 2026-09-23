package pathqueryparam;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class PathQueryParamsExtra {
	// http://localhost:3000/students
    // http://localhost:3000/students?page=1&id=202

    @Test(priority=0)
    void testQueryAndPathParameters() {

        given()
            .pathParam("mypath", "students")
            .queryParam("page", 1)
            .queryParam("id", 201)

        .when()
            .get("http://localhost:3000/{mypath}")

        .then()
            .statusCode(200)
            .log().all();
    }
    @Test(priority=1)
    public void patQuery2()
    {

    	    given()
    	        .pathParam("mypath", "students")
    	        .queryParam("id", 202)

    	    .when()
    	        .get("http://localhost:3000/{mypath}")

    	    .then()
    	        .statusCode(200)
    	        .log().all();
    }
}