package jparsec.text;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;

import jparsec.kernel.Parsec;
import jparsec.kernel.ParsecException;
import jparsec.kernel.State;

public class SepBy<T, S, E> extends Parsec<List<T>, E> {

	private Parsec<T, E> p;
	private Parsec<S, E> by;
	
	public SepBy(Parsec<T, E> p, Parsec<S, E> by){
		this.p = p;
		this.by = by;
	}
	
	@Override
	public List<T> parse(State<E> s) throws EOFException, ParsecException {
		List<T> list = new ArrayList<T>();
		try{
			list.add(p.parse(s));
			while(true){
				by.parse(s);
				list.add(p.parse(s));
			}
		}catch(EOFException e){
			return list;
		}catch(ParsecException e){
			return list;
		}
	}

}
