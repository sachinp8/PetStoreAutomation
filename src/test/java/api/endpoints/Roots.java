package api.endpoints;
/* swagger url : https://petstore.swagger.io/v2
 * create user (Post): https://petstore.swagger.io/v2/user
 * Get user (GET) : https://petstore.swagger.io/v2/user/{username}
 * Update user(PUT) : https://petstore.swagger.io/v2/user/{username}
 * Delete User (DELETE) : https://petstore.swagger.io/v2/user/{username}
 * 
 * 
 */

public class Roots {
	
	public static String base_url = "https://petstore.swagger.io/v2"
			+ "";
	
	//USER MODULE
	
	public static String post_url = base_url+"/user";
	public static String get_url = base_url+"/user/{username}";
	public static String update_url = base_url+"/user/{username}";
	public static String delete_url = base_url+"/user/{username}";
	
	// STORE MODULE

}
