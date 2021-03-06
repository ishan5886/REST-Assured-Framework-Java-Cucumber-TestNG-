package APITesting;
import java.net.http.HttpRequest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_Post_Request {

	@SuppressWarnings("unchecked")
	@Test
	void getUsers() {
		
		//Specify Base URL
		RestAssured.baseURI="https://reqres.in/api/users";
		
		//Create Request Object
		
		RequestSpecification httprequest = RestAssured.given();
		
		//Create Response Object
		 
		//Request Payload along with Post Request
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("name","morpheus");
		requestParams.put("job","leader");
		
		httprequest.header("Content-Type","application/json");
		
		httprequest.body(requestParams.toJSONString()); //attach data to request
		
		
		//Response object
		Response response=httprequest.request(Method.POST,"");
		
		String responseBody = response.getBody().asString();  //Response body will be in JSON format. asString() method will convert it to String
		
		System.out.println("Response Body is: " +responseBody);	
		
		
		//Status Code Validation
		int statusCode = response.getStatusCode();
		System.out.println("Status Code is: " +statusCode);
		Assert.assertEquals(statusCode, 201);
		
		String name = response.jsonPath().get("name");
		System.out.println(name);
		String job = response.jsonPath().get("job");
		System.out.println(job);
		Assert.assertEquals(name, "morpheus");
		Assert.assertEquals(job, "leader");
		
		
		
			
	}


}
