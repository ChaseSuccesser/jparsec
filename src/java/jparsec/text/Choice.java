package jparsec.text;

import java.io.EOFException;

import jparsec.kernel.Parsec;
import jparsec.kernel.ParsecException;
import jparsec.kernel.State;

public class Choice<T, E> extends Parsec<T, E>{
	
	private Parsec<T,E>[] parsecs;

	@Override
	public T parse(State<E> s) throws EOFException, ParsecException {
		for(Parsec<T, E> parsec : parsecs){
			try {
				return parsec.parse(s);
			} catch (EOFException  e) {
				continue;
			} catch(ParsecException e){
				continue;
			}
		}
		
		throw new ParsecException(s.index(), "Choice Error : All parsec parser failed.");
	}

	public Choice(Parsec<T, E> ...parsecs){
		this.parsecs = parsecs;
	}
}
