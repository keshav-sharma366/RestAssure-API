package diffwayreqs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class Pojo_PostReq {
    String id;

    @Test(priority=1)
    public void postReqByJsonOrg()
    {
        PostReq_POJO1 data = new PostReq_POJO1();
        data.setName("Ruchi");
        data.setLocation("Noida");
        data.setPhone("9999117343");
        String coursesArr[] = {"Java", "Selenium"};
        data.setCourses(coursesArr);

        id = given()
            .contentType("application/json")
            .body(data)

        .when()
            .post("http://localhost:3000/students")

        .then()
            .statusCode(201)
            .body("name", equalTo("Keshav"))
            .body("location", equalTo("UP"))
            .body("phone", equalTo("1234567890"))
            .body("courses[0]", equalTo("Java"))
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