package fourachievers.lf.exceptions;

public class InvalidPropertyFileException extends InvalidPathForFilesException {

	public InvalidPropertyFileException(String message) {
		super(message);
		
	}
	
	public InvalidPropertyFileException(String message,Throwable cause) {
		super(message,cause);
		
	}

}
