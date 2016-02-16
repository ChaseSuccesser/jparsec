package jparsec.kernel;

public class ParsecException extends RuntimeException {

	private static final long serialVersionUID = -3006676073110314578L;
	
	private String message;
	private int index;
	
	public ParsecException(int index, String message){
		super(message);
		this.index = index;
		this.message = message;
	}
	
	public String getMessage(){
		return this.message;
	}
	
	public int getIndex(){
		return this.index;
	}
}
