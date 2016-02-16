package JparsecTest;

import jparsec.kernel.State;
import jparsec.text.Text;

import org.junit.Test;

public class TextTest extends Base {
	
	@Test
	public void test() throws Exception{
		State<Character> state = newState("hello world");
		
		Text text = new Text("hello world");
		
		String result = text.parse(state);
		
		System.out.println(result);
	}
}
