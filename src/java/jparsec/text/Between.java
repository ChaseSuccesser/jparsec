package jparsec.text;

import java.io.EOFException;

import jparsec.kernel.Parsec;
import jparsec.kernel.ParsecException;
import jparsec.kernel.State;

public class Between<T,E,O,C> extends Parsec<T, E> {
	
	private Parsec<O,E> open;
	private Parsec<C,E> close;
	private Parsec<T,E> parsec;
	
	public Between(Parsec<O,E> open, Parsec<C,E> close, Parsec<T,E> parsec){
		this.open = open;
		this.close = close;
		this.parsec = parsec;
	}

	@Override
	public T parse(State<E> s) throws EOFException, ParsecException {
		open.parse(s);
		T t = parsec.parse(s);
		close.parse(s);
		return t;
	}
}
