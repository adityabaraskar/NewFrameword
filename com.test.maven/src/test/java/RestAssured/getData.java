package RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class getData {
	
	//GEtting Status Code
	
	@Test
	
	public void getStatusCode() {
		
	//	Response resp =RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		
		Response resp = get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		
		int code = resp.getStatusCode();
		
		System.out.println("Status code is :"+code);
		
		Assert.assertEquals(code, 200);
		
	}
	
	
	//Getting the body
	
@Test
	
	public void getBody() {
		
		//Response resp =RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		
		//String body= resp.asString();
		String data =get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").asString();
		long tm =get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").getTime();
		
		System.out.println("Status code is :"+data);
		
		System.out.println("REsponse Time is:"+tm);
		
		
	}

}
