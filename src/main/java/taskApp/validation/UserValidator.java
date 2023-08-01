/**
 * 
 */
package taskApp.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import taskApp.model.User;
import taskApp.validation.exceptions.InvalidUserException;

/**
 * @author Vinit Gore
 *
 **/
public class UserValidator {

	public static boolean validateUser(User user) throws InvalidUserException {

		// User is valid if username is valid and email is valid and password is valid
		if (user != null && validateName(user.getUsername()) && validateEmail(user.getEmail())
				&& validatePassword(user.getPassword())) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");
		}

	}

	public static boolean validateName(String name) {
		boolean match = false;
		if (name == null)
			return false;
		String regex = "^[A-Za-z]\\w{2,29}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		match = m.matches();
		if (match) {
			System.out.println("The user name is valid.");
		} else {
			System.out.println("The user name is not valid");
		}
		return match;
	}

	public static boolean validatePassword(String password) {
		if (password == null)
			return false;
		boolean match = false;
		String pattern_string = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
		match = Pattern.matches(pattern_string, password);

		if (match) {
			System.out.println("Valid password.");
		} else {
			System.out.println("Invalid password.");
		}

		return match;
	}

	public static boolean validateEmail(String email) {
		if (email == null)
			return false;
		boolean isMatch = false;

		String regex = "^.*@.*\\..*$";
		isMatch = Pattern.matches(regex, email);
		if (isMatch) {
			System.out.println("The email address is: Valid");
		} else {
			System.out.println("The email address is: Invalid");
		}
		return isMatch;

	}
}
