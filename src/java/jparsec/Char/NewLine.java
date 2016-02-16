package jparsec.Char;

import java.io.EOFException;

import jparsec.kernel.Parsec;
import jparsec.kernel.ParsecException;
import jparsec.kernel.State;

/**
 * 
 * @author ligx
 * NewLine 匹配\n
 */
public class NewLine extends Parsec<String, Character> {

	@Override
	public String parse(State<Character> s) throws EOFException, ParsecException {
		new Char('\n').parse(s);
		return "\n";
	}

}
