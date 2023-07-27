/**
 * 
 */
package taskApp.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import taskApp.model.User;

/**
 * @author Vinit Gore
 *
 **/
public class UserValidator {
	
	public static boolean validateUser(User user) throws IllegalArgumentException {
		
		// User is valid if username is valid and email is valid and password is valid

		if (user != null && validateName(user.getUsername()) && validateEmail(user.getEmail()) && validatePassword(user.getPassword())) {
			return true;
		} else {
			throw new IllegalArgumentException("User details not valid");
		}
		
		
	}
	
	
	public static boolean validateName(String name) {
		boolean match = false;
		try {
			String regex = "^[A-Za-z]\\w{2,29}$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(name);
			match = m.matches();
			if (match) {
				System.out.println("The user name is valid.");
			} else {
				System.out.println("The user name is not valid");
			}
		} catch (Exception e) {
			System.out.println("user name is not valid");
		}
		return match;
	}

	public static boolean validatePassword(String password) {
		boolean match = false;
		try {
//			String pattern_string = "(?=.*[0-9])(?=.*[a-z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
//			String pattern_string = "(?=.*[0-9])(?=.*[A-Z])(?=\\S+$).{8,}";
			String pattern_string = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
			match = Pattern.matches(pattern_string, password);
//			boolean match = pattern.matches(password);
//			Pattern pattern = Pattern.compile(pattern_string);
//			Matcher m = pattern.matcher(password);

			if (match) {
//			if (m.matches()) {
				System.out.println("Valid password.");
			} else {
				System.out.println("Invalid password.");
			}
		} catch (PatternSyntaxException e) {
			System.out.println(e.getMessage());
		}

		return match;
	}

	public static boolean validateEmail(String email) {
		boolean isMatch = false;
		try {
			String regex = "^.*@.*\\..*$";
			isMatch = Pattern.matches(regex, email);
			if (isMatch) {
				System.out.println("The email address is: Valid");
			} else {
				System.out.println("The email address is: Invalid");
			}
			return isMatch;
		} catch (PatternSyntaxException e) {
			System.out.println(e.getMessage());
		}
		return isMatch;
	}
}