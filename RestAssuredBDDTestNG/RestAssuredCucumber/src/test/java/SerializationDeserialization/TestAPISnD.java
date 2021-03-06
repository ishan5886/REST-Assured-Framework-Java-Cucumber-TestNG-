package SerializationDeserialization;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import restAssuredBDDTests.RestUtils;
import static org.hamcrest.Matchers.*;
import org.hamcrest.Matchers;
import org.mozilla.javascript.ast.NewExpression;

import static io.restassured.RestAssured.*;

public class TestAPISnD {
	
	
	@Test(priority = 1)
	public void createNewUserSerialization()
	{
		
		User us = new User();
		us.setName(RestUtils.empName());
		us.setJob(RestUtils.empJob());
		
		given().contentType(ContentType.JSON)
		.body(us)
		.when().post("https://reqres.in/api/users")
		.then().statusCode(201);
		
	}
	

	@Test(priority = 2)
	public void getUserDeSerialization()
	{
		
		User us = get("https://reqres.in/api/users").as(User.class);
		System.out.println(us.getJob());

		System.out.println(us.getName());
		
	}
	
}
