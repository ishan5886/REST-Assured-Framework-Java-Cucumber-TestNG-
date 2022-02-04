package restAssuredBDDTests;


import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



public class TC_001_GET_Request {
	
	
	
	@Test
	void getUsers() {
		
		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.assertThat().body("data[2].first_name", equalTo("Tobias"))
		.header("Content-Type", "application/json; charset=utf-8");


}
}
