/**
 * 
 */
package taskApp.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import taskApp.model.User;
import taskApp.services.UserService;
import taskApp.services.exceptions.ServiceException;

/**
 * @author Vinit Gore
 *
 **/
public class TestRegisterFeature {
//	public static void main(String[] args) {
//		UserService userService = new UserService();
//		
//		// Create a new user
//		User user1 = new User("Vinit", "vinit.gore@ctr.freshworks.com", "Password@123");
//		
//		// Call register method from the app object
//		try {
//			userService.registerUser(user1);
//		} catch (ServiceException e) {
//			e.printStackTrace();
//		}
//	}

	@Test
	public void testRegistrationSuccess() {
		UserService userService = new UserService();

		// Create a custom input for user
		User user = new User("Vinit", "vinit.gore@ctr.freshworks.com", "Password@123");

		try {
			assertTrue(userService.registerUser(user));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}

	}
	
	@Test
	public void testUserNull() {
		UserService userService = new UserService();

		// Create a custom input for user
		User user = null;
		try {
			assertFalse(userService.registerUser(user));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
