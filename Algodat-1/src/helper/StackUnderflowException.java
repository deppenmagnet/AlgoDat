/**
 * 
 */
package helper;

/**
 * @author Stefan Lange
 *
 */
public class StackUnderflowException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7015114878113907194L;

	/**
	 * 
	 */
	public StackUnderflowException() {
		super();
		System.out.println("There are no elements on the stack left to pop()");
	}
	
	

}
