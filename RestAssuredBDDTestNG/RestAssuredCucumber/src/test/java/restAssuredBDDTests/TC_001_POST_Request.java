package restAssuredBDDTests;


import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;



public class TC_001_POST_Request {
	
	
	public static HashMap map = new HashMap();
	
	
	@BeforeClass
	
	public void postData() {
		map.put("name", RestUtils.empName());
		map.put("job", RestUtils.empJob());
		
		RestAssured.baseURI = "https://reqres.in/api/users";
	}
	
	
	
	@Test
	void getUsers() {
		
		given()
			.body(map)
		.when()
			.post()
		.then()
		.statusCode(201)
		.assertThat().time(Matchers.lessThan(30L));
		


}
}
