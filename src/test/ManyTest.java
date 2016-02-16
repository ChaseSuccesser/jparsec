package JparsecTest;

import java.util.List;

import jparsec.Char.Eq;
import jparsec.kernel.State;
import jparsec.text.Many;

import org.junit.Test;

public class ManyTest extends Base {
	
	@Test
	public void test() throws Exception{
		State<Character> state = newState("hhello");
		
		Many<Character, Character> many = new Many<Character,Character>(new Eq<Character>('h'));
		
		List<Character> list =  many.parse(state);
		
		for(Character c : list){
			System.out.println(c);
		}
	}
}
