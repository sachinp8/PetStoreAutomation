package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.Dataprovider;
import io.restassured.response.Response;

public class DDtest {

	@Test(priority=1,  dataProvider="Data", dataProviderClass=Dataprovider.class)
	public void Testpostuser(String UserID,String UserName,String FirstName,String LastName,String Email,String Password,String Phone) {
		
		User UserPayload = new User();
		
		UserPayload.setId(Integer.parseInt(UserID));
		UserPayload.setUsername(UserName);
		UserPayload.setFirstName(FirstName);
		UserPayload.setLastName(LastName);
		UserPayload.setEmail(Email);
		UserPayload.setPassword(Password);
		UserPayload.setPhone(Phone);
		
		Response response = UserEndPoints.createuser(UserPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=2,  dataProvider="UserNames", dataProviderClass=Dataprovider.class)
	public void testDeleteUserByName(String UserName)
	{
		
		Response response = UserEndPoints.deleteuser(UserName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
