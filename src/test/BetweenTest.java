package test;

import jparsec.Char.Eq;
import jparsec.kernel.State;
import jparsec.text.Between;
import junit.framework.Assert;

import org.junit.Test;

public class BetweenTest extends Base {
	
	@Test
	public void test() throws Exception{
		State<Character> state = newState("hello");
		
		Between<Character, Character, Character, Character> between = new Between<Character, Character, Character, Character>(
				new Eq<Character>('h'),
				new Eq<Character>('l'),
				new Eq<Character>('e'));
		
		Character c = between.parse(state);
		
		Assert.assertEquals(c, new Character('e'));
	}
}
