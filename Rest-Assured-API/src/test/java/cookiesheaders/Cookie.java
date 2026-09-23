package cookiesheaders;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Cookie {
	@Test(priority=0)
	void testCookie()
	{
	    given()

	    .when()
	        .get("https://www.google.com/")

	    .then()
	        .log().all();
	}

	@Test(priority=1)
	void checkCookie()
	{
		 Response res=given()

				    .when()
				        .get("https://www.google.com/");


				    //get single cookie info
				    String cookie_value=res.getCookie("AEC");
				    System.out.println("Value of cookie is====>"+cookie_value);
	}
	
	@Test(priority=2)
	void getAllCookie()
	{
	   Response res= given()

	    .when()
	        .get("https://www.google.com/");

	 //   .then()
	 //       .cookie("AEC","AakniGOLxRQC9fgi6mjPYfT76_mMHEZC-z_5xRB2ApPi8Ag2HZdJvBWMxZU")
	 //       .log().all();
	        
	 // get all cookies info
	    Map<String,String> cookies_values=res.getCookies();

	    //System.out.println(cookies_values.keySet());

	    for(String k:cookies_values.keySet())
	    {
	        String cookie_value=res.getCookie(k);
	        System.out.println(k+"        "+cookie_value);
	    }   
	        
	}
}
