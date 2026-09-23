package cookiesheaders;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersTest {
	
		@Test(priority=0)
		void testHeader()
		{
			given()

			.when()
			    .get("https://www.google.com/")

			.then()
			    .header("Content-Type","text/html; charset=ISO-8859-1")
			    .and()
			    .header("Content-Encoding", "gzip")
			    .and()
			    .header("Server", "gws")
			    .log().headers();
		}
		
		@Test(priority=1)
		void testSingleHeaderInfo()
		{
			// getting header from response
			Response res=given()

			.when()
			    .get("https://www.google.com/");

		/*	.then()
			    .header("Content-Type","text/html; charset=ISO-8859-1")
			    .and()
			    .header("Content-Encoding", "gzip")
			    .and()
			    .header("Server", "gws");
			    */
			
			String valu_Header=res.getHeader("Content-Type");
			System.out.println("The Value of Header is :"+valu_Header);
		}
		
		@Test(priority=2)
		void getAllHeaders()
		{
			Response res= given()
					
					.when()
					.get("https://www.google.com");
			//to get all headers
		Headers myheaders=res.getHeaders();
		for(Header hd:myheaders)
		{
			System.out.println(hd);
		}
					
		}
}
