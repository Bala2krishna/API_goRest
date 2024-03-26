package resources;

import com.github.javafaker.Faker;

import pojo.AddUser;

public class TestDataBuilder {

	
	Faker faker;
	
	public AddUser addUserPayload() {
		
		
		AddUser adduser =new AddUser();
		faker=new Faker();
		
		adduser.setName(faker.name().toString());
		adduser.setEmail(faker.internet().emailAddress());
		adduser.setGender("Male");
		adduser.setStatus("Active");
		
		return adduser;
	}
}
