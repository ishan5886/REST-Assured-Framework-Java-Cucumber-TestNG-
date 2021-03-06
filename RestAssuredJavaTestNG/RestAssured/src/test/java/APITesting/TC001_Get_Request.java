package APITesting;

import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_Get_Request {
	
	@Test
	void getUsers() {
		
		//Specify Base URL
		// RestAssured.baseURI="https://reqres.in/api/users";
		
		RestAssured.baseURI="https://reqres.in/api/users";
		
		//*****************************Create Request Object//
		
		RequestSpecification httprequest = RestAssured.given();
		
		//Create Response Object
		
		Response response = httprequest.request(Method.GET, "/7");
		
		
		//*****************Print response in console window//
		
		String responseBody = response.getBody().asString();  //Response body will be in JSON format. asString() method will convert it to String
		
		System.out.println("Response Body is: " +responseBody);	
		
		
		//***********************************Status Code Validation//
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//***************************Status Line verification//
		
		String statuslineString=response.getStatusLine();
		System.out.println(statuslineString);
		Assert.assertEquals(statuslineString, "HTTP/1.1 200 OK");
		
		//***********************************Header verification//
		 String contentType=response.header("Content-Type");
		 System.out.println("Content Type is : "+contentType);
		 Assert.assertEquals(contentType,"application/json; charset=utf-8");
		
		
		//********************************8Printing All Headers//
		 
		 
		Headers allHeaders = response.headers(); // capture all headers from response
		
		for(Header header :allHeaders)
		{
		
			System.out.println(header.getName()+"       "+header.getValue());
		}
		
		
		//*************Extract Value of Each Node in the JSON
		
		JsonPath jsonPath1=response.jsonPath();
		
		//System.out.println(jsonPath1);
		
		System.out.println(jsonPath1.get("data.email"));
		System.out.println(jsonPath1.get("data.first_name"));
		System.out.println(jsonPath1.get("data.last_name"));
		
	}

}
