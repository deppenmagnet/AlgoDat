/**
 * 
 */
package helper;

/**
 * @author Stefan Lange
 *
 */
public class QueueEmptyException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6050788915829495201L;

	/**
	 * 
	 */
	public QueueEmptyException() {
		super();
		System.out.println("There is noting to dequeue!");
	}

}
