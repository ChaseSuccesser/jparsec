package JparsecTest;

import jparsec.kernel.BaseState;
import jparsec.kernel.State;


public abstract class Base {

	State<Character> newState(String data){
		Character[] buffer = new Character[data.length()];
		for(int i=0; i<data.length(); i++){
			buffer[i] = data.charAt(i);
		}
		return new BaseState<Character>(buffer);
	}
}
