/**
 * 
 */
package taskApp.services;

import taskApp.model.User;
import taskApp.services.exceptions.ServiceException;
import taskApp.validation.UserValidator;
import taskApp.validation.exceptions.InvalidUserException;

import java.sql.SQLException;

import taskApp.dao.UserDAO;
import taskApp.dao.exceptions.DAOException;

/**
 * @author Vinit Gore
 *
 **/
public class UserService {
	public boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();

		try {
			UserValidator.validateUser(user);
			if (userDAO.createUser(user)) {
				System.out.println(user.getUsername() + " successfully registered!");
				return true;
			} else {
				System.out.println("Registration not successful!");
				return false;
			}

		} catch (DAOException |
				InvalidUserException e) {
			throw new ServiceException(e);
		}
	}
}
