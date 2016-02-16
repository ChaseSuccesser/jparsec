package test;

import java.util.List;

import jparsec.Char.Eq;
import jparsec.kernel.State;
import jparsec.text.ManyTill;

import org.junit.Test;

public class ManyTillTest extends Base {
	
	@Test
	public void test() throws Exception{
		State<Character> state = newState("hhhhhhlhhhll");

        ManyTill<Character, Character, Character> m = new ManyTill<Character, Character, Character>(
                new Eq<Character>('h'),
                new Eq<Character>('l')
        );

        List<Character> list = m.parse(state);
		
		for(Character c : list){
			System.out.println(c);
		}
	}
}
