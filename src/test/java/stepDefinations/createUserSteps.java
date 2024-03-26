package stepDefinations;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;
import pojo.AddUser;
import resources.ApiResources;
import resources.TestDataBuilder;
import resources.Utils;


public class createUserSteps extends Utils {

	//RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	Response response;
	RequestSpecification req;
	//String authcode="Bearer 32ea2a6f0870e7a30114344f0685596e95480eb3ebf3b7edabaa2fed87445ffd";
	String userID;

	@Given("I have request payload and have authorization key to add user in GoRest")
	public void i_have_authorization_key_to_add_user_in_go_rest() throws IOException {


		TestDataBuilder data=new TestDataBuilder();



		 req=given().spec(reqSpecification()).body(data.addUserPayload())
				
				
				.headers("Authorization",Utils.getGlobalValue("Authorization"));

		



	}

	@When("I call {string} a new user API with POST http request")
	public void i_call_api_with_http_request(String resource ) {
		
		ApiResources resourseAPI=ApiResources.valueOf(resource);
		System.out.println(resourseAPI.getResource());
		

		resSpec=new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON)
				.expectStatusCode(201)
				.build();


		response= req.when().post(resourseAPI.getResource())
				.then().spec(resSpec).extract().response();
		
		userID=getJsonPath(response,"id");

System.out.println(userID);


	}

	@Then("I should get status code as {int}")
	public void i_should_get_status_code_as(Integer statuscode) {


		int actualStatus=response.getStatusCode();
		Integer integerObject = Integer.valueOf(actualStatus);
			Assert.assertEquals(integerObject, statuscode);

	}

	@Then("status as {string}")
	public void status_as_with_in_response(String string) {


		String statusLine=response.getStatusLine();


			Assert.assertTrue(statusLine.contains("Created"));


	}


	@Given("I have userID and have authorization key to add user in GoRest")
	public void i_have_and_have_authorization_key_to_add_user_in_go_rest() throws IOException {
		
		
		 req=given().spec(reqSpecification())
				 //.pathParam(userID,userID )
					
					
					.headers("Authorization",Utils.getGlobalValue("Authorization"));
		
		
	}

	@Then("status as {string} with {string} in responses")
	public void status_as_with_in_responses(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}


	@Given("I have {string} and have authorization key to get user in GoRest")
	public void i_have_and_have_authorization_key_to_get_user_in_go_rest(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
	
//	@When("I call {string} API with {string} http request")
//	public void i_call_api_with_http_request(String resource, String verb) {
//		
//		ApiResources resourseAPI=ApiResources.valueOf(resource);
//		System.out.println(resourseAPI.getResource());
//		
//		if(string.equalsIgnoreCase("delete_user")&& string2.equalsIgnoreCase("DELETE")) {
//			
//			
//			
//		}
//		
//
//		else if(string.equalsIgnoreCase("patch_user")&& string2.equalsIgnoreCase("PATCH")) {
//			
//			
//			
//		}
//		
//
//		else if(string.equalsIgnoreCase("get_user")&& string2.equalsIgnoreCase("GET")) {
//			
//			
//			
//		}
//
//
//		
//		
//	}


}





