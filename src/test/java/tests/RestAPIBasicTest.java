package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pages.RestAPIBasicPage;

public class RestAPIBasicTest {
	
	String sCity="Pune";
	RestAPIBasicPage objRestAPIBasicPage=null;
	int OK =200;
	String STATUSLINE="HTTP/1.1 200 OK";
	
	@BeforeMethod()
	void setUpRestAssured()
	{
		RestAssured.baseURI="https://demoqa.com/utilities/weather/city";
		objRestAPIBasicPage = new RestAPIBasicPage();
	}
	
	@Test()
	void testResponseFromServer()
	{
		objRestAPIBasicPage.getResponseFromServer(sCity);
		Assert.assertTrue(!(objRestAPIBasicPage.getResponseBodyFromServer().isEmpty()), sCity+ " city dont have a data in server");
	}
	
	@Test()
	void testStatusCodeOfResponse()
	{
		objRestAPIBasicPage.getResponseFromServer(sCity);
		Assert.assertEquals(objRestAPIBasicPage.getStatusCodeFromServer(), OK);
	}
	
	
	@Test()
	void testStatusLineOfResponse()
	{
		objRestAPIBasicPage.getResponseFromServer(sCity);
		System.out.println(objRestAPIBasicPage.getStatusLineFromServer());
		Assert.assertEquals(objRestAPIBasicPage.getStatusLineFromServer(), STATUSLINE);
	}

	@Test()
	void testPrintHeaders()
	{
		objRestAPIBasicPage.getResponseFromServer(sCity);
		objRestAPIBasicPage.printAllHeaders();
		System.out.println(objRestAPIBasicPage.printHeaderValue("Content-Type"));
		System.out.println(objRestAPIBasicPage.printHeaderValue("Content-Length"));
		System.out.println(objRestAPIBasicPage.printHeaderValue("Connection"));
		System.out.println(objRestAPIBasicPage.printHeaderValue("Server"));
	}
}
