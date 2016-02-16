package jparsec.kernel;

import java.io.EOFException;

public class Try<T, E> extends Parsec<T, E>{
	
	private Parsec<T, E> parsec;
	
	public Try(Parsec<T, E> parsec){
		this.parsec = parsec;
	}

	@Override
	public T parse(State<E> s) throws EOFException, ParsecException {
		int tran = s.begin();
		try{
			T t = parsec.parse(s);
			s.commit(tran);
			return t;
		}catch(EOFException e){
			s.rollback(tran);
			throw e;
		}catch(ParsecException e){
			s.rollback(tran);
			throw e;
		}
	}

}   
