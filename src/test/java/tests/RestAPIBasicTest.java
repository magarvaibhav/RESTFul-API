package tests;

import org.testng.Assert;
import org.testng.Reporter;
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
		Reporter.log(objRestAPIBasicPage.getStatusLineFromServer());
		Assert.assertEquals(objRestAPIBasicPage.getStatusLineFromServer(), STATUSLINE);
	}

	@Test()
	void testPrintHeaders()
	{
		objRestAPIBasicPage.getResponseFromServer(sCity);
		objRestAPIBasicPage.printAllHeaders();
		Reporter.log(objRestAPIBasicPage.printHeaderValue("Content-Type"));
		Reporter.log(objRestAPIBasicPage.printHeaderValue("Content-Length"));
		Reporter.log(objRestAPIBasicPage.printHeaderValue("Connection"));
		Reporter.log(objRestAPIBasicPage.printHeaderValue("Server"));
	}
}
