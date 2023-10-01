package api.endpoints;
import static io.restassured.RestAssured.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// userEndPoint.java
//created for perform Create,read,Update and Delete Request to user API.
public class UserEndPoints {
	
	public static Response createuser(User payload){
		Response response =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(Roots.post_url);
		
		return response;
	}

	public static Response readuser(String userName){
		Response response =given()
		.pathParam("username", userName)
		.when()
		.get(Roots.get_url);
		
		return response;
	}
	
	public static Response updateuser(String userName,User payload){
		Response response =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.pathParam("username", userName)
		.when()
		.put(Roots.update_url);
		
		return response;
	}
	
	public static Response deleteuser(String userName){
		Response response =given()
		.pathParam("username", userName)
		.when()
		.delete(Roots.delete_url);
		
		return response;
	}
}
