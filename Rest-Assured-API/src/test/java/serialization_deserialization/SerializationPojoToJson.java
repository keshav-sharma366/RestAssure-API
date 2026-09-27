package serialization_deserialization;
// pojo------sereial------JSOnObject-----deserial-------pojo

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class SerializationPojoToJson {
	@Test
	void convertPojo2Json() throws JsonProcessingException

	{
	    //created java object using pojo class
	    Student stupojo=new Student();     //pojo

	    stupojo.setName("Scott");
	    stupojo.setLocation("France");
	    stupojo.setPhone("123456");
	    String coursesArr[]= {"C","C++"};
	    stupojo.setCourses(coursesArr);

	    //convert java objet ---> json object ( serilization)
	    ObjectMapper objMapper=new ObjectMapper();

	    String jsondata=objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(stupojo);

	    System.out.println(jsondata);

	}

}
