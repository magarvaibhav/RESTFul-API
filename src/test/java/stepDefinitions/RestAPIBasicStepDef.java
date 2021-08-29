package stepDefinitions;

import org.testng.Assert;
import org.testng.Reporter;
import io.cucumber.java.en.*;
import pages.RestAPIBasicPage;

public class RestAPIBasicStepDef {

	String sCity = "Pune";
	RestAPIBasicPage objRestAPIBasicPage = new RestAPIBasicPage();
	int OK = 200;
	String STATUSLINE = "HTTP/1.1 200 OK";

	@Given("get response from server")
	public void get_response_from_server() {
		objRestAPIBasicPage.getResponseFromServer(sCity);
		Assert.assertTrue(!(objRestAPIBasicPage.getResponseBodyFromServer().isEmpty()),
				sCity + " city dont have a data in server");
	}

	@Then("check status code of response")
	public void check_status_code_of_response() {
		objRestAPIBasicPage.getResponseFromServer(sCity);
		Assert.assertEquals(objRestAPIBasicPage.getStatusCodeFromServer(), OK);
	}

	@Then("check status line of response")
	public void check_status_line_of_response() {
		objRestAPIBasicPage.getResponseFromServer(sCity);
		Reporter.log(objRestAPIBasicPage.getStatusLineFromServer());
		Assert.assertEquals(objRestAPIBasicPage.getStatusLineFromServer(), STATUSLINE);
	}

	@Then("check headers of response")
	public void check_headers_of_response() {
		objRestAPIBasicPage.getResponseFromServer(sCity);
		objRestAPIBasicPage.printAllHeaders();
		Reporter.log(objRestAPIBasicPage.printHeaderValue("Content-Type"));
		Reporter.log(objRestAPIBasicPage.printHeaderValue("Content-Length"));
		Reporter.log(objRestAPIBasicPage.printHeaderValue("Connection"));
		Reporter.log(objRestAPIBasicPage.printHeaderValue("Server"));
	}
}
