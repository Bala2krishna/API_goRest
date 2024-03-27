package stepDefinations;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
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

	RequestSpecification req;
	ResponseSpecification resSpec;
	Response response;
	
	//String authcode="Bearer 32ea2a6f0870e7a30114344f0685596e95480eb3ebf3b7edabaa2fed87445ffd";
	Integer userID;
	
	
	 @Given("I have authorization key to get users in GoRest")
	 
	 public void i_have_authorization_key_to_getusers_in_go_rest() throws IOException {



				//to initialize common request specification we build with reqSpecification method and in continue to specific method request
		      req=given().spec(reqSpecification());
						
				
			}

	@Given("I have request payload and have authorization key to add user in GoRest")
	public void i_have_authorization_key_to_add_user_in_go_rest() throws IOException {

    //to create test data using faker library with pojo class
		TestDataBuilder data=new TestDataBuilder();


		//to initialize common request specification we build with reqSpecification method and in continue to specific method request
		 req=given().spec(reqSpecification()).body(data.addUserPayload());
				
		
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



	@Then("status as {string} with {string} in responses")
	public void status_as_with_in_responses(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}


	@Given("I have userID and have authorization key to get user in GoRest")
	public void i_have_and_have_authorization_key_to_get_user_in_go_rest() throws IOException {
		
		if (req==null) {
		
			
				req=given().spec(reqSpecification());
		}
	}
	
	@When("I call {string} API with {string} http request")
	public void i_call_api_with_http_request(String resource, String verb) throws IOException {
		
		ApiResources resourseAPI=ApiResources.valueOf(resource);
		System.out.println(resourseAPI.getResource());
		
		
		
		if(verb.equalsIgnoreCase("DELETE")) {
			
			response= req.pathParam("userID", userID).when().delete(resourseAPI.getResource());
			
	}
		else if(verb.equalsIgnoreCase("GETusers")) {
			
			
			//here req getting null so test case getting fail
			if(req==null) {
				req=given().spec(reqSpecification());
			}
			response= req.when().get(resourseAPI.getResource())
					.then().spec(resSpecification()).extract().response();
					
			
		}else if(verb.equalsIgnoreCase("POST")) {
	
		
			
			response= req.when().post(resourseAPI.getResource())
					.then().spec(resSpecification()).extract().response();
			
			
			userID=Integer.valueOf(getJsonPath(response,"id"));
			
			System.out.println(userID);
		

	
}
		else if(verb.equalsIgnoreCase("PATCH")) {
			
			TestDataBuilder udata=new TestDataBuilder();
			
			response= req.body(udata.updateUserPayload()).pathParam("userID", 6809079).when().patch(resourseAPI.getResource())
					.then().spec(resSpecification()).extract().response();
		}
			else if(verb.equalsIgnoreCase("GETUser")) {
	
	
	
	response= req.pathParam("userID", 6809079).when().get(resourseAPI.getResource())
			.then().spec(resSpecification()).extract().response();


		
		
	}


	}
}





