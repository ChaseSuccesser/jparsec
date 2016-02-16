package jparsec.text;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;

import jparsec.kernel.Parsec;
import jparsec.kernel.ParsecException;
import jparsec.kernel.State;

public class Many<T,E> extends Parsec<List<T>, E>{
	
	private Parsec<T,E> parsec;

	@Override
	public List<T> parse(State<E> s) throws EOFException, ParsecException {
		List<T> list = new ArrayList<T>();
		try{
			while(true){
				list.add(this.parsec.parse(s));
			}
		}catch(EOFException e){
			return list;
		}catch(ParsecException e){
			return list;
		}
	}
	
	public Many(Parsec<T,E> parsec){
		this.parsec = parsec;
	}
}
