package JparsecTest;

import jparsec.Char.OneOf;
import jparsec.kernel.State;

import org.junit.Test;

public class OneOfTest extends Base {
	
	@Test
	public void test() throws Exception{
		State<Character> state = newState("hello");
		
		Character[] cs = new Character[]{'h','b'};
		OneOf<Character> oneof = new OneOf<Character>(cs);
		
		oneof.parse(state);
		
		Character c = oneof.parse(state);
		
		System.out.println(c);
	}
}
