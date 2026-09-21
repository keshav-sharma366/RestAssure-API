package diffwayreqs;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class PostReqByHashMap {

    String id;   // yaha store hoga created student ka id

    @Test(priority=1)
    public void postReq()
    {
        HashMap data = new HashMap();

        data.put("name", "Scott");
        data.put("location", "France");
        data.put("phone", "123456");

        String courseArr[] = {"C", "C++"};
        data.put("courses", courseArr);

        id = given()
            .contentType("application/json")
            .body(data)

        .when()
            .post("http://localhost:3000/students")

        .then()
            .statusCode(201)
            .body("name", equalTo("Scott"))
            .body("location", equalTo("France"))
            .body("phone", equalTo("123456"))
            .body("courses[0]", equalTo("C"))
            .body("courses[1]", equalTo("C++"))
            .header("Content-Type", "application/json")
            .log().all()
            .extract()
            .path("id");   // response body se "id" field extract kar liya

        System.out.println("Created ID: " + id);
    }

    // Deleting student record
    @Test(priority=2)
    void testDelete()
    {
        given()

        .when()
            .delete("http://localhost:3000/students/" + id)   // dynamic id use ho raha hai

        .then()
            .statusCode(200);
    }
}