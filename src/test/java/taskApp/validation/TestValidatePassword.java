/**
 * 
 */
package taskApp.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * @author Vinit Gore
 *
 **/
public class TestValidatePassword {
	
	@Test
	public void testValidPassword() {
		assertTrue(UserValidator.validatePassword("Password@123"));
		
	}
	
	@Test
	public void testInvalidPasswordWithoutSpecialCharacters() {
		assertFalse(UserValidator.validatePassword("Password123"));
	}
	
	@Test
	public void testInvalidPasswordWithoutNumbers() {
		assertFalse(UserValidator.validatePassword("Password@"));
	}
	
	@Test
	public void testInvalidPasswordWithoutCapitalLetters() {
		assertFalse(UserValidator.validatePassword("password@123"));
	}
	
	@Test
	public void testInvalidPasswordWithoutSmallLetters() {
		assertFalse(UserValidator.validatePassword("PASSWORD@123"));
	}
	
	@Test
	public void testInvalidPasswordShorterLength() {
		// Length less than 8
		assertFalse(UserValidator.validatePassword("Pas@123"));
	}
}
