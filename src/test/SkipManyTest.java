package JparsecTest;

import jparsec.Char.Eq;
import jparsec.kernel.State;
import jparsec.text.SkipMany;
import junit.framework.Assert;

import org.junit.Test;

public class SkipManyTest extends Base {
	
	@Test
	public void test() throws Exception{
		State<Character> state = newState("hehlo");
		
		SkipMany<Character, Character> skipmany = new SkipMany<Character, Character>(new Eq<Character>('h'));
		
		Character c = skipmany.parse(state);
		Assert.assertEquals(c, null);
		
		Character d = state.next();
        Assert.assertEquals(d,new Character('e'));

        Character e = skipmany.parse(state);
        Assert.assertEquals(e,null);
        
        Character f = state.next();
        Assert.assertEquals(f,new Character('l'));
	}
}
