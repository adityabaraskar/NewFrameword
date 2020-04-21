package RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetAuth extends BaseClass {
	
	@Test
	
	
	public void getResponseCode()  {
		
		//FOllowing Code is comment when we use BAse Class
		
		/*int code = RestAssured.given()
		.auth().preempetive.basic("ToolsQA", "TestPassword")
		.when()
		.get("http://restapi.demoqa.com/authentication/CheckForAuthentiacation/")
		.getStatusCode();*/
		
		//New line added
		
		
		int code = RestAssured.given()
				.get()
				.getStatusCode();
		
		System.out.println("Status code is :"+code);
		


		
	}

}
