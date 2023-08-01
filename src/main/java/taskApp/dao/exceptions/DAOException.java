/**
 * 
 */
package taskApp.dao.exceptions;

/**
 * @author Vinit Gore
 *
 **/
public class DAOException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2814072310045781779L;

	public DAOException(String msg) {
		super(msg);
	}

	public DAOException(Throwable e) {
		super(e);
	}
}
