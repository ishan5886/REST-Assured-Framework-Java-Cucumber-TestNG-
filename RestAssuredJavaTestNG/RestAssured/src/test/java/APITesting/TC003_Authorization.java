package APITesting;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_Authorization {
	
	@Test
	public void Authorization() 
	
	{
	
		//Specify Base URL
		// RestAssured.baseURI="https://reqres.in/api/users";
		
		RestAssured.baseURI="https://postman-echo.com/basic-auth";
		
		//Basic Authentication
		
		PreemptiveBasicAuthScheme authScheme= new PreemptiveBasicAuthScheme();
		authScheme.setUserName("postman");
		authScheme.setPassword("password");
		
		
		RestAssured.authentication=authScheme;
		
		
		//*****************************Create Request Object//
		
		RequestSpecification httprequest = RestAssured.given();
		
		//Create Response Object
		
		Response response = httprequest.request(Method.GET, "/");
		
		
		
		//***********************************Status Code Validation//
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200);
				
		
		
		//*****************Print response in console window//
		
		String responseBody = response.getBody().asString();  //Response body will be in JSON format. asString() method will convert it to String
		
		System.out.println("Response Body is: " +responseBody);	
	}

}
