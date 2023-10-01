package api.endpoints;
import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// userEndPoint.java
//created for perform Create,read,Update and Delete Request to user API.
public class UserEndPoints2 {
	
	//Created for getting URL's from files
	static ResourceBundle getURL(){
		
	ResourceBundle roots = ResourceBundle.getBundle("Roots"); // Load properties file
	return roots;
	}
	public static Response createuser(User payload){
		
		String post_url=getURL().getString("post_url");
		Response response =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(post_url);
		
		return response;
	}

	public static Response readuser(String userName){
		
		String get_url=getURL().getString("get_url");
		Response response =given()
		.pathParam("username", userName)
		.when()
		.get(get_url);
		
		return response;
	}
	
	public static Response updateuser(String userName,User payload){
		
		String update_url=getURL().getString("update_url");
		Response response =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.pathParam("username", userName)
		.when()
		.put(update_url);
		
		return response;
	}
	
	public static Response deleteuser(String userName){
		
		String delete_url=getURL().getString("delete_url");
		Response response =given()
		.pathParam("username", userName)
		.when()
		.delete(delete_url);
		
		return response;
	}
}
