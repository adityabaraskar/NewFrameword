package RestAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/*The URL in this code are not working*/


public class CookiesAuth {

	
	@Test
	
	public void getSeessionId() {
		
		
		
		JSONObject json = new JSONObject();
		
		json.put("username","abaraskar");
		json.put("password","Smeralda");


		//Getting JSESSIONID
		
		
		Response resp =RestAssured.given()
		.header("Content-Type","application/json")
		.body(json)
		.post("https://localhost0870.atlassian.net/rest/auth/1/session");//You get this url from https://developer.atlassian.com/server/jira/platform/cookie-based-authentication/
		                                                                  //This URL is not working.
		
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getBody().jsonPath().prettify());
		//System.out.println(resp.getCookies());
		String sessionID = resp.getCookies().get("JSESSIONID");
		
		//Sending payload to create task
		
		
		Response response = (Response) RestAssured.given().contentType(ContentType.JSON)
							.cookie("JSESSIONID",sessionID)
							.body("{\r\n" + 
									"    \"fields\": {\r\n" + 
									"       \"project\":\r\n" + 
									"       {\r\n" + 
									"          \"key\": \"ADI\"\r\n" + 
									"       },\r\n" + 
									"       \"summary\": \"REST ye merry gentlemen.\",\r\n" + 
									"       \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n" + 
									"       \"issuetype\": {\r\n" + 
									"          \"name\": \"Bug\"\r\n" + 
									"       }\r\n" + 
									"   }\r\n" + 
									"}\r\n" + 
									"")
							.post("http://localhost:8080/rest/api/2/project");//You get this url from https://developer.atlassian.com/server/jira/platform/jira-rest-api-examples/
		
		System.out.println(response.getBody().jsonPath().prettify());
		
	}
}
