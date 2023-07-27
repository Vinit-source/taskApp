/**
 * 
 */
package taskApp.service;

import taskApp.model.User;
import taskApp.validation.UserValidator;

import java.sql.SQLException;

import taskApp.dao.UserDAO;

/**
 * @author Vinit Gore
 *
 **/
public class UserService {
	public boolean registerUser(User user) throws SQLException {
		UserDAO userDAO = new UserDAO();
		if (UserValidator.validateUser(user)) {
			return userDAO.register(user);
		} else {
			return false;
		}
	}
}
