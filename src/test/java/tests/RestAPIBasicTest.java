package tests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPIBasicTest {
	
	public static void main(String arg[])
	{
		String sCity="Pune";
		//set BaseURL for RESTful web service
		RestAssured.baseURI="https://demoqa.com/utilities/weather/city";
		
		//get requestSpecification from restAssued using given method
		RequestSpecification objRequestSpecification = RestAssured.given();
		
		//specify method name and URL and get response from server
		Response response = objRequestSpecification.request(Method.GET,"/"+sCity);
		
		//get all data of response and convert in string and print
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);

		
	}

}
