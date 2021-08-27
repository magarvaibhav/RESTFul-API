package pages;

import io.restassured.RestAssured;
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
			System.out.println("Name : "+href.getName()+" Value : "+href.getValue());
		}

	}
	
	public String printHeaderValue(String headerName)
	{
		return response.getHeader(headerName);
	}
	
}
