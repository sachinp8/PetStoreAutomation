package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {

	Faker faker;
	User userPayload;
	
	public Logger logger;
	
	@BeforeClass
	public void setup() {
		
		faker = new Faker();
		userPayload= new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		userPayload.setUserStatus(faker.idNumber().hashCode());
		
		
		// logs
		logger = LogManager.getLogger(this.getClass());
	}
	
	@Test(priority=1)
	public void TestpostUser() {
		logger.info("********Creating user************");
		
		Response response = UserEndPoints.createuser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("********Creating user************");
	
	}
	@Test(priority=2)
	public void TestgetUser() {
		
		logger.info("********Reading User Info************");
		
		Response response =UserEndPoints.readuser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("********Reading User Info************");
	}
	
	@Test(priority=3)
	public void TestupdateUser() {
		
		logger.info("********Update User Info************");
		//update user data
		
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
	
		
		Response response = UserEndPoints.updateuser(this.userPayload.getUsername(),userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("********Update User Info************");
		
		//response update after updating user
		Response afterresponse =UserEndPoints.readuser(this.userPayload.getUsername());
		afterresponse.then().log().all();
		
		logger.info("********Update User Info************");
	}
	@Test(priority=4)
	public void TestdeleteUser() {
		
		logger.info("********Deleting User Info************");
		
		Response response =UserEndPoints.deleteuser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("********Deleting User Info************");
	}
		
	
}
