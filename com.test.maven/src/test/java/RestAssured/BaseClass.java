package RestAssured;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class BaseClass {
	
	@BeforeClass
	public void getAuthencation() {
		
		RestAssured.authentication =  RestAssured.preemptive().basic("ToolsQA", "TestPassword");
		
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentiacation/";
	}

}
