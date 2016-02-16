package jparsec.Char;

import java.io.EOFException;

import jparsec.kernel.Parsec;
import jparsec.kernel.ParsecException;
import jparsec.kernel.State;


/**
 * 
 * @author ligx
 * Eq 即 anyChar, 匹配任何字符。返回解析的字符.
 */
public class Eq<E> extends Parsec<E, E> {
	
	private E item;
	
	public Eq(E item){
		this.item = item;
	}

	@Override
	public E parse(State<E> s) throws EOFException, ParsecException {
		E e = s.next();
		if(e.equals(item)){
			return e;
		}else{
			String message = String.format("Expect %s is equal to %s", e, item);
			throw new ParsecException(s.index(), message);
		}
	}
}
