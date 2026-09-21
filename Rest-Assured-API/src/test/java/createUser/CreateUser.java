package createUser;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class CreateUser {
	int id;
	@Test
	public void createUser()
	{
		HashMap data=new HashMap();
		data.put("name", "Keshav");
		data.put("job","consultant");
		id=given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		
	}
}
