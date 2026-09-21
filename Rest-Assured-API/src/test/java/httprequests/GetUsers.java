package httprequests;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

/*
given()
  content type, set cookies, add auth, add param, set headers info etc....

when()
  get, post, put, delete

then()
  validate status code, extract response, extract headers cookies & response body....

*/

public class GetUsers {
	int id;
	@Test(priority=1)
	public void getUsers()
	{
		given()
		
				.when()
					.get("https://reqres.in/api/users?page=2")
		
						.then()
							.statusCode(200)
							.body("page", equalTo(2))
							.log().all();
	}
	@Test(priority=2)
	public void getUser()
	{
		given()
				.when()
				.get("https://reqres.in/api/users/2")
			
					.then()
					.statusCode(200)
					.log().all();
	}
	@Test(priority=3)
	public void postUser()
	{
		{
		    HashMap data = new HashMap();
		    data.put("name", "Keshav");
		    data.put("job", "Associate");

		   id= given()
		        .contentType("application/json")
		        .body(data)

		    .when()
		        .post("https://reqres.in/api/users")
		        .jsonPath().getInt("id");

		  /*  .then()
		        .statusCode(201)
		        .log().all(); */
		}
		System.out.println("id is "+id);
	}
	@Test(priority=4)
	public void deleteUser()
	{
		given()
			
		.when()
			.delete("https://reqres.in/api/users/"+id)
			
		.then()
			//.statusCode(201)
			.log().all();
	}
	

}
