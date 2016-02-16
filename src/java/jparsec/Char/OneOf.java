package jparsec.Char;

import java.io.EOFException;
import java.util.Arrays;

import jparsec.kernel.Parsec;
import jparsec.kernel.ParsecException;
import jparsec.kernel.State;

public class OneOf<E> extends Parsec<E, E> {
	
	private E[] items;
	
	public OneOf(E[] items){
		this.items = items;
	}

	@Override
	public E parse(State<E> s) throws EOFException, ParsecException {
		E e = s.next();
		for(E item : this.items){
			if(item == e){
				return e;
			}
		}
		String message = String.format("Expect %s in %s", e, Arrays.toString(this.items));
		throw new ParsecException(s.index(), message);
	}

}
