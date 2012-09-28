/**
 * 
 */
package be.technobel.domain.exceptions;

/**
 * @author jonmeu
 *
 */
public class RepositoryException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RepositoryException(String message){
		super(message);
	}
}
