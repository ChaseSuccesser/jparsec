package jparsec.text;

import java.io.EOFException;

import jparsec.kernel.Parsec;
import jparsec.kernel.ParsecException;
import jparsec.kernel.State;

public class SkipMany<T, E> extends Parsec<T, E> {

	private Parsec<T, E> parsec;
	
	public SkipMany(Parsec<T, E> parsec){
		this.parsec = parsec;
	}
	
	@Override
	public T parse(State<E> s) throws EOFException, ParsecException {
		int tran = 0;
		try{
			while(true){
				tran = s.begin();
				parsec.parse(s);
				s.commit(tran);
			}
		}catch(EOFException e){
			s.rollback(tran);
		}catch(ParsecException e){
			s.rollback(tran);
		}
		return null;
	}

}
