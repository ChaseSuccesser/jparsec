package jparsec.text;

import java.io.EOFException;

import jparsec.kernel.Parsec;
import jparsec.kernel.ParsecException;
import jparsec.kernel.State;

/**
 * @author pc
 * Eof 期待 state 的 next 操作取到 eof 状态
 */
public class Eof<E> extends Parsec<Object, E> {

	@Override
	public Object parse(State<E> s) throws EOFException, ParsecException {
		try{
			E e = s.next();
			String message = String.format("Expect eof but %s", e);
            throw new ParsecException(s.index(), message);
		}catch(EOFException e){
			return null;
		}
	}

}
