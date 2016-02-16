package jparsec.Char;

import java.io.EOFException;

import jparsec.kernel.Parsec;
import jparsec.kernel.ParsecException;
import jparsec.kernel.State;


/**
 * @author ligx
 * Digit 判断下一个项是否是一个表示数字的字符.它仅接受 Character/char.
 */
public class Digit extends Parsec<Character, Character> {

	@Override
	public Character parse(State<Character> s) throws EOFException, ParsecException {
		Character c = s.next();
		if(Character.isDigit(c)){
			return c;
		}else{
			String message = String.format("Expect %s is digit", c);
			throw new ParsecException(s.index(), message);
		}
	}
}
