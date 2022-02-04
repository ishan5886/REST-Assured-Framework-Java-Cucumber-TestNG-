package SerializationDeserialization;

import java.util.HashMap;

import org.testng.annotations.Test;

import restAssuredBDDTests.RestUtils;
import static org.hamcrest.Matchers.*;
import org.hamcrest.Matchers;
import static io.restassured.RestAssured.*;

public class TestAPINoSerialization {
	
	public HashMap map = new HashMap();
	
	@Test(priority = 1)
	public void createNewUser()
	{
		map.put("name", RestUtils.empName());
		map.put("job", RestUtils.empJob());
		
		
		
		given()
		.body(map)
		.when().post("https://reqres.in/api/users")
		.then().statusCode(201);
		
	}
	
	
	

}
