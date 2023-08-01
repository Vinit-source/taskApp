/**
 * 
 */
package taskApp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import taskApp.model.User;
import taskApp.dao.exceptions.*;
/**
 * @author Vinit Gore
 *
 **/
public class UserDAO {
	// Connect to database
		public Connection getConnection() throws SQLException {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "123456");
			return connection;
		}

		// Get user from DB - Login
//		public boolean login(String email, String password) {
//			
//		}

		// Add new user to DB - Register
		public boolean createUser(User user) throws DAOException {
			String insertQuery = "INSERT INTO user (email, username, password) VALUES (?, ?, ?)";
			try (
			// Get Connection
			Connection connection = getConnection();
			
			// Prepare SQL statement
			PreparedStatement pst = connection.prepareStatement(insertQuery);) {
			pst.setString(1, user.getEmail());
			pst.setString(2, user.getUsername());
			pst.setString(3, user.getPassword());
			
			// Execute the query on database
			int rows = pst.executeUpdate();
			
			// Return successful or not
			return (rows == 1);
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
}
