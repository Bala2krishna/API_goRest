package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Properties;

//import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	
	RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	//Response response;
	//RequestSpecification req;
	
	
	public ResponseSpecification resSpecification() {
		
		if(resSpec==null) {
			
			resSpec=new ResponseSpecBuilder()
					.expectContentType(ContentType.JSON)
					//.expectStatusCode(201)
					.build();
			
			return resSpec;
			
		}else return resSpec;
		
		
		
	}
	
	
	
	
	public RequestSpecification reqSpecification() throws IOException {
		
		
		
		if(reqSpec==null) {
			
						
					
						PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));
						
						
						reqSpec=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).setContentType(ContentType.JSON)
								.addHeader("Authorization",Utils.getGlobalValue("Authorization"))
								//.setAuth(authcode)
								
								.addFilters(LoggingUtil.getLoggingFilters())
								//.addFilter(RequestLoggingFilter.logRequestTo(log))       //replaced with logutils
								//.addFilter(ResponseLoggingFilter.logResponseTo(log))
								//.addFilter(new AllureRestAssured()
								//.withRequestTemplate("custom-http-request.ftl")
								//.withResponseTemplate("custom-http-response.ftl"))
								.build();
						
							return reqSpec;
			}
				else return reqSpec;
	}
	
	

	
	public static String getGlobalValue(String key) throws IOException {
		
		
		
		Properties prop=new Properties();
		//System.out.println(System.getProperty("user.dir"));
		/*
		 * C:\Users\btulshalapuram\eclipse-workspace\POC_API_Framework\src\test\java\resources\global.properties
		 */
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\global.properties");
		
		prop.load(fis);
		
		
		return prop.getProperty(key);
		
	}
	
	
	public String getJsonPath(Response response,String key)
	{
		  String resp=response.asString();
		JsonPath   js = new JsonPath(resp);
		return js.get(key).toString();
	}
}
