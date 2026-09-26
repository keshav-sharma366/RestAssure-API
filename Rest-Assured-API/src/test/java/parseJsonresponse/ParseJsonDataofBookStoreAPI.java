package parseJsonresponse;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParseJsonDataofBookStoreAPI {

	@Test(priority=1)
	public void testRespone()
	{
		Response res= given()
			    .contentType(ContentType.JSON)

			.when()
			    .get("http://localhost:3000/books");

		Assert.assertEquals(res.getStatusCode(),200);   //validation 1
		Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");

		JSONArray ja = new JSONArray(res.asString());

		for(int i=0; i<ja.length(); i++)
		{
		    String bookTitle = ja.getJSONObject(i).get("title").toString();
		    System.out.println(bookTitle);
		}
	}

	@Test(priority=2)
	public void validateResponse()
	{
		boolean status=false;
		Response res= given()
			    .contentType(ContentType.JSON)

			.when()
			    .get("http://localhost:3000/books");

		Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");

		JSONArray ja = new JSONArray(res.asString());

		for(int i=0; i<ja.length(); i++)
		{
		    String bookTitle = ja.getJSONObject(i).get("title").toString();
		    if(bookTitle.equals("Atomic Habits"))
		    {
		    	status=true;
		    	break;
		    }
		}
		Assert.assertEquals(status, true);

		//validate total price of books    - validation 2

		double totalprice=0;
		for(int i=0; i<ja.length(); i++)
		{
		    String price = ja.getJSONObject(i).get("price").toString();
		    totalprice = totalprice + Double.parseDouble(price);
		}

		System.out.println("total price of books is:"+ totalprice);
		Assert.assertEquals(totalprice, 2995.0);
	}

}