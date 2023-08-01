/**
 * 
 */
package taskApp.services.exceptions;

/**
 * @author Vinit Gore
 *
 **/
public class ServiceException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7552369350705475986L;

	public ServiceException(String msg) {
		super(msg);
	}

	public ServiceException(Throwable e) {
		super(e);
	}
}
