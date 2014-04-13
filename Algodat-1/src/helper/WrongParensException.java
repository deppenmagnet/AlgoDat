package helper;

public class WrongParensException extends RuntimeException {

	/**
	 * @author Stefan Lange
	 */
	private static final long serialVersionUID = 6491245449617627721L;

	/**
	 * 
	 */
	public WrongParensException() {
		super();
		System.out.println("Opening and closing parens do NOT match!");
	}

}
