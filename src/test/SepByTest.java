package JparsecTest;

import java.util.List;

import jparsec.Char.Eq;
import jparsec.kernel.State;
import jparsec.text.SepBy;

import org.junit.Test;

public class SepByTest extends Base {

	@Test
	public void test() throws Exception{
		State<Character> state = newState("hlhlhlhlhll");
		
		SepBy<Character, Character, Character> sepby = new SepBy<Character, Character, Character>(
				new Eq<Character>('h'),
				new Eq<Character>('l')
		);
		
		List<Character> list = sepby.parse(state);
		
		System.out.println(list);
	}
}
