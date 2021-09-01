package pages;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPIBasicPage {

	RequestSpecification objRequestSpecification =null;
	Response response=null;
	
	public Response getResponseFromServer(String sCity)
	{
		//get requestSpecification from restAssued using given method
		objRequestSpecification = RestAssured.given();
		
		//specify method name and URL and get response from server
		response = objRequestSpecification.request(Method.GET,"/"+sCity);
	
		//return
		return response;
	}
	
	public String getResponseBodyFromServer()
	{
		return response.getBody().asString();
	}
	
	public int getStatusCodeFromServer()
	{
		return response.getStatusCode();
	}

	public String getStatusLineFromServer() {
		return response.getStatusLine();

	}
	
	public void printAllHeaders() {
		Headers objHeaders = response.getHeaders();
		
		for(Header href : objHeaders)
		{
			Reporter.log("Name : "+href.getName()+" Value : "+href.getValue());
		}

	}
	
	public String printHeaderValue(String headerName)
	{
		return response.getHeader(headerName);
	}

	public JSONObject getJsonDataForPost() {
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender"); 
		requestParams.put("LastName", "Singh");

		requestParams.put("UserName", "simpleuser001");
		requestParams.put("Password", "password1");
		requestParams.put("Email",  "someuser@gmail.com");
		return requestParams;
	}

	public void writeDataOnServer(JSONObject data) {
		objRequestSpecification = RestAssured.given();
		objRequestSpecification.contentType(ContentType.JSON);
		objRequestSpecification.body(data.toString());
		Response response = objRequestSpecification.request(Method.POST,"/register");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, "201");
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
	
		
	}
	
}
