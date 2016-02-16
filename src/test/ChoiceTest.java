package test;

import jparsec.Char.Eq;
import jparsec.kernel.State;
import jparsec.text.Choice;

import org.junit.Test;

public class ChoiceTest extends Base {
	
	@Test
	public void test() throws Exception{
		State<Character> state = newState("hhello");
		
		Choice<Character, Character> choice = new Choice<Character, Character>(
				new Eq<Character>('d'),
				new Eq<Character>('d'),
				new Eq<Character>('e'),
				new Eq<Character>('d'));
		
		Character c = choice.parse(state);
		
		System.out.println(c);
	}
}
