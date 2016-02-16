package jparsec.Char;

import java.io.EOFException;

import jparsec.kernel.Parsec;
import jparsec.kernel.ParsecException;
import jparsec.kernel.State;

/**
 * @author ligx
 * Crlf 匹配\n\r
 */
public class Crlf extends Parsec<String, Character>{

	@Override
	public String parse(State<Character> s) throws EOFException, ParsecException {
		new Char('\n').parse(s);
		new Char('\r').parse(s);
		return "\n\r";
	}

}
