/******************************************************
Test Name: Delete an employee record
URI: http://dummy.restapiexample.com/api/v1/delete/{id}
Request Type: DELETE
Request Payload(Body): NA
********* Validations **********
Response Payload(Body) : {"success":{"text":"successfully! deleted Records"}}
Status Code : 200
Status Line : HTTP/1.1 200 OK
Content Type : text/html; charset=UTF-8
Server Type :  nginx/1.14.1
Content Encoding : gzip
**********************************************************/

package com.api.testcases;

import static org.hamcrest.CoreMatchers.nullValue;

import org.testng.Assert;
import org.testng.annotations.*;

import com.api.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TC005_Delete_User_Record extends TestBase{

	RequestSpecification httpRequest;
	Response response;
		
	@BeforeClass
	void deleteEmployee() throws InterruptedException
	{
		logger.info("*********Started TC005_Delete_Employee_Record **********");
		
		RestAssured.baseURI = "https://reqres.in/api/users";
		httpRequest = RestAssured.given();
		
		response = httpRequest.request(Method.GET, "");
				
		// First get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();
			 
		//Capture id
		String empID=jsonPathEvaluator.get("[0].data.id");
		response = httpRequest.request(Method.DELETE, "/"+empID); //Pass ID to delete record
		
		Thread.sleep(3000);
	}
	
	@Test
	void checkResposeBody()
	{
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains(""), true);

	}
		
	@Test
	void checkStatusCode()
	{
		int statusCode = response.getStatusCode(); // Gettng status code
		Assert.assertEquals(statusCode, 204);
	}
		
	@Test
	void checkstatusLine()
	{
		String statusLine = response.getStatusLine(); // Gettng status Line
		Assert.assertEquals(statusLine, "HTTP/1.1 204 No Content");
		
	}
	
//	@Test
//	void checkContentType()
//	{
//		String contentType = response.header("Content-Type");
//		Assert.assertEquals(contentType, nullValue());
//	}

	@Test
	void checkserverType()
	{
		String serverType = response.header("Server");
		Assert.assertEquals(serverType, "cloudflare");
	}

//	@Test
//	void checkcontentEncoding()
//	{
//		String contentEncoding = response.header("Content-Encoding");
//		Assert.assertEquals(contentEncoding, nullValue());
//
//	}

	@AfterClass
	void tearDown()
	{
		logger.info("*********  Finished TC005_Delete_Employee_Record **********");
	}
}