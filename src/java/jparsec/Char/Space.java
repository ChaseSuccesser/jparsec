package jparsec.Char;

import java.io.EOFException;

import jparsec.kernel.Parsec;
import jparsec.kernel.ParsecException;
import jparsec.kernel.State;

/**
 * 
 * @author ligx
 * Space 匹配空格
 */
public class Space extends Parsec<Character, Character> {

	@Override
	public Character parse(State<Character> s) throws EOFException, ParsecException {
		Character c = s.next();
		if(Character.isSpaceChar(c)){
			return c;
		}else{
			String message = String.format("Expect %c is space.", c);
            throw new ParsecException(s.index(), message);
		}
	}
}
