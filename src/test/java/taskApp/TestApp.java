/**
 * 
 */
package taskApp;

import java.sql.SQLException;

import taskApp.model.User;
import taskApp.service.UserService;

/**
 * @author Vinit Gore
 *
 **/
public class TestApp {
	public static void main(String[] args) {
		App app = new App();
		
		// Create a new user
		User user1 = new User("Lakshmi", "lakshmipriya.suntharaj@fssa.freshworks.com", "Muthu@123");
		UserService userService = new UserService();
		
		// Call register method from the app object
		try {
			if (userService.registerUser(user1)) {
				System.out.println(user1.getUsername() + " successfully registered!");
			};
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
