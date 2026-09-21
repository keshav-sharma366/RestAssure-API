package diffwayreqs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class PostReqByExterJsonFile {
    String id;

    @Test(priority=1)
    public void postReqByExterJson() throws FileNotFoundException
    {
        File file=new File("./jsonData.json");
        FileReader fr=new FileReader(file);
        JSONTokener jtk=new JSONTokener(fr);
        JSONObject data=new JSONObject(jtk);

        id = given()
            .contentType("application/json")
            .body(data.toString())

        .when()
            .post("http://localhost:3000/students")

        .then()
            .statusCode(201)
            .body("name", equalTo("Devish"))
            .body("location", equalTo("Delhi"))
            .body("phone", equalTo("05738271353"))
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