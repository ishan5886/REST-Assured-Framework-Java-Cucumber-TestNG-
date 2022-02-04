package restAssuredBDDTests;

import org.testng.annotations.Test;
import org.hamcrest.Matchers;


import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TC005_Demo_BasicValidations_JSON {
	
	@Test(priority=1)
	public void teststatuscode() {
		
		given()
		.when()
		.get("https://jsonplaceholder.typicode.com/posts/5")
		.then()
		.statusCode(200);
		
		
		
	}
	
	@Test(priority=2)
	public void testLogging() {
		
		given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.log().all(); //all info on response
		
		
		
	}
	
	@Test(priority=3)
	public void testSingleContent() {
		
		given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.body("data[2].first_name",equalTo("Tobias"));
		
		
		
	}
	
	
	@Test(priority=4)
	public void testMultipleContent() {
		
		given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.body("data.first_name", hasItems("Michael", "Tobias", "Byron", "Rachel"));
		
		
		
	}	
	
	
	
	@Test(priority=5)
	public void testParamsAndHeaders() {
		
		given()
		.param("MyName","pavan")
		.header("MyHeader", "Indian")
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.log().all();
		
		
		
	}	

}

















