package DataDrivenAPITesting;

import java.io.IOException;

import org.apache.batik.bridge.UserAgent;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DDT_TC_001_POST_Add_New_Users {
	
			
	@Test(dataProvider = "userdataproviderexcel")
			
	void postNewUsers(String ename, String ejob)

	
	{
			
	
	
			//Specify Base URL
	
			RestAssured.baseURI="https://reqres.in/api/users";
			
			//Create Request Object
			
			RequestSpecification httprequest = RestAssured.given();
			
			
			//Request Payload along with Post Request
			
			JSONObject requestParams = new JSONObject();
			
			requestParams.put("name",ename);
			requestParams.put("job",ejob);
			
			//Add a header stating that the Request body is a JSON
			httprequest.header("Content-Type","application/json");
			
			// Add the Json to the body of the request
			httprequest.body(requestParams.toJSONString());
			
			//Response object
			Response response=httprequest.request(Method.POST,"");
			
			// Capture response body to perform validations
			String responseBody = response.getBody().asString();  //Response body will be in JSON format. asString() method will convert it to String
			
			System.out.println("Response Body is: " +responseBody);	
			
			Assert.assertEquals(responseBody.contains(ename),true);
			Assert.assertEquals(responseBody.contains(ejob),true);
			
			//Status Code Validation
			int statusCode = response.getStatusCode();
			System.out.println("Status Code is: " +statusCode);
			Assert.assertEquals(statusCode, 201);
			
			
			
	}
	
	
	@DataProvider(name="userdataprovider")
	String[][] postNewUsers2DArray() 
			
	{
		//Hard coded 2D Array
		String empdata[][] = {{"rohit", "batsman"}, {"virat", "captain"}, {"zaheer", "bowler"}};
		return(empdata);
		
				
				
	}
	
	
	@DataProvider(name="userdataproviderexcel")
	String[][] postNewUsersExcelUtility() throws IOException 
			
	{
		//Excel Data
		
		String path = System.getProperty("user.dir")+"/src/test/java/DataDrivenAPITesting/Data2.xls";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colnum = XLUtils.getCellCount(path, "Sheet1", 1);
		
		
		String userdata[][] = new String[rownum][colnum];
		
		for(int i=1; i<=rownum; i++)
		{
			for(int j=0; j< colnum; j++)
			{
				userdata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		
		
		//String empdata[][] = {{"rohit", "batsman"}, {"virat", "captain"}, {"zaheer", "bowler"}};
		return(userdata);
		
				
				
	}
		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			

	
}