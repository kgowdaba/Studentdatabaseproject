package customexception;
//5.exception class
public class InvalidChoiceException  extends RuntimeException{
	private String message;
	public InvalidChoiceException(String message) {
		this.message=message;
	}
	@Override
	public String getMessage() {
		return message;
	}
}
