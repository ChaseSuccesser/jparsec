package jparsec.text;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;

import jparsec.kernel.Parsec;
import jparsec.kernel.ParsecException;
import jparsec.kernel.State;

public class Count<T, E> extends Parsec<List<T>, E> {

	private int count;
	private Parsec<T, E> parsec;
	
	public Count(int count, Parsec<T, E> parsec){
		this.count = count;
		this.parsec = parsec;
	}
	
	@Override
	public List<T> parse(State<E> s) throws EOFException, ParsecException {
		List<T> list = new ArrayList<T>();
		if(this.count <= 0){
			return null;
		}else{
			try {
				while(count > 0){
					list.add(parsec.parse(s));
					count--;
				}
			} catch (ParsecException e){
				String message = String.format("Count Error");
				throw new ParsecException(s.index(), message);
			}
			return list;
		}
	}

}
