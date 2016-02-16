package JparsecTest;

import java.util.List;

import jparsec.Char.Eq;
import jparsec.kernel.State;
import jparsec.text.Count;

import org.junit.Test;

public class CountTest extends Base {
	
	@Test
	public void test() throws Exception{
		State<Character> state = newState("hhhhddh");
		
		Count<Character, Character> count = new Count<Character, Character>(4, new Eq<Character>('h'));
		
		List<Character> list = count.parse(state);
		
		System.out.println(list);
	}
}
