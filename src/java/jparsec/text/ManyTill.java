package jparsec.text;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;

import jparsec.kernel.Parsec;
import jparsec.kernel.ParsecException;
import jparsec.kernel.State;
import jparsec.kernel.Try;

public class ManyTill<T, L, E> extends Parsec<List<T>, E> {

	private Parsec<T, E> parser;
	private Parsec<L, E> end;
	
	public ManyTill(Parsec<T, E> parser, Parsec<L, E> end){
		this.parser = new Try<T, E>(parser);
		this.end = end;
	}
	
	@Override
	public List<T> parse(State<E> s) throws EOFException, ParsecException {
		List<T> list = new ArrayList<T>();
		
		while(true){
			try{
				end.parse(s);
				return list;
			}catch(EOFException e){
				list.add(parser.parse(s));
			}catch(ParsecException e){
				list.add(parser.parse(s));
			}
		}
	}

}
