package jparsec.Char;

import java.io.EOFException;
import java.util.Arrays;

import jparsec.kernel.Parsec;
import jparsec.kernel.ParsecException;
import jparsec.kernel.State;

public class NoneOf<E> extends Parsec<E, E>{
	
	private E[] items;
	
	public NoneOf(E[] items){
		this.items = items;
	}

	@Override
	public E parse(State<E> s) throws EOFException, ParsecException {
		E e = s.next();
		for(E item : this.items){
			if(item == e){
				String message = String.format("expect a item not in %s but got %s", Arrays.toString(this.items), e);
                throw new ParsecException(s.index(), message);
			}
		}
		return e;
	}

}
