package restAssuredBDDTests;

import org.testng.annotations.Test;
import org.hamcrest.Matchers;


import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TC006_Demo_BasicValidations_XML {
	

	
	@Test(priority=1)
	public void testContent() {
		
		given()
		.when()
		.get("https://chercher.tech/sample/api/books.xml")
		.then()
		.body("bookstore.book[0].author",equalTo("Hannah"))
		.body("bookstore.book[0].year",equalTo("2015")) //Multiple body to test multiple data
		.log().all();
		
		
		
	}
	
	
	@Test(priority=2)
	public void testMultipleContentInOneGo() {
		
		given()
		.when()
		.get("https://chercher.tech/sample/api/books.xml")
		.then()
		.body("bookstore.book[0].text()", equalTo("The NightingaleHannah2015200570"))
		.log().all();
		
		
		
	}
	
	
	
	@Test(priority=3)
	public void testXPath() {
		
		given()
		.when()
		.get("https://chercher.tech/sample/api/books.xml")
		.then()
		.body(hasXPath("/bookstore/book[1]", containsString("Hannah")));
		
		
		
	}
	
	

}

















