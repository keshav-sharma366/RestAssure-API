package diffwayreqs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class PostReqByOrgJson {
    String id;

    @Test(priority=1)
    public void postReqByJsonOrg()
    {
        JSONObject data = new JSONObject();

        data.put("name", "Keshav");
        data.put("location", "UP");
        data.put("phone", "1234567890");

        String courseArr[] = {"JAVA", "Selenium"};
        data.put("courses", courseArr);

        id = given()
            .contentType("application/json")
            .body(data.toString())

        .when()
            .post("http://localhost:3000/students")

        .then()
            .statusCode(201)
            .body("name", equalTo("Keshav"))
            .body("location", equalTo("UP"))
            .body("phone", equalTo("1234567890"))
            .body("courses[0]", equalTo("JAVA"))
            .body("courses[1]", equalTo("Selenium"))
            .header("Content-Type", "application/json")
            .log().all()
            .extract()
            .path("id");     // <-- ye add kiya, id yaha se extract ho raha hai

        System.out.println("Created ID: " + id);
    }

    @Test(priority=2)
    void testDeleteReq()
    {
        given()

        .when()
            .delete("http://localhost:3000/students/" + id)

        .then()
            .statusCode(200);
    }
}