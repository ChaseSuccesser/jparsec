package jparsec.text;

import java.io.EOFException;

import jparsec.kernel.Parsec;
import jparsec.kernel.ParsecException;
import jparsec.kernel.State;

/**
 * @author ligx
 * Text 即Hsakell Parsec中的string
 */
public class Text extends Parsec<String, Character> {

	private String text;
	
	public Text(String text){
		this.text = text;
	}
	
	@Override
	public String parse(State<Character> s) throws EOFException, ParsecException {
		int index = 0;
		
		for(Character c : text.toCharArray()){
			Character data = s.next();
			if(c != data){
				String message = String.format("Expect %s at %d but %s", c, index, data);
				throw new ParsecException(s.index(), message);
			}
			index++;
		}
		
		return text;
	}

}
