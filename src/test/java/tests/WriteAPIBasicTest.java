package tests;

import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import pages.RestAPIBasicPage;

public class WriteAPIBasicTest {
	
	String sCity="Pune";
	RestAPIBasicPage objRestAPIBasicPage=null;
	int OK =200;
	String STATUSLINE="HTTP/1.1 200 OK";
	
	@BeforeMethod()
	void setUpRestAssured()
	{
		RestAssured.baseURI="http://www.appdomain.com/users/123/accounts";
		objRestAPIBasicPage = new RestAPIBasicPage();
	}
	
	@Test()
	void testPostRequestServer()
	{
		JSONObject data = objRestAPIBasicPage.getJsonDataForPost();
		objRestAPIBasicPage.writeDataOnServer(data);
	}
	

}
