package jparsec.kernel;

import java.io.EOFException;

import jparsec.kernel.State;

public class BaseState<E> implements State<E> {
	
	private E[] buffer;
	private int current = 0;
	private int tran = -1;
	
	public BaseState(E[] buffer){
		this.buffer = buffer;
	}

	public E next() throws EOFException {
		if(this.current >= buffer.length){
			throw new EOFException();
		}
		E e = buffer[this.current];
		this.current++;
		return e;
	}

	public int index() {
		return current;
	}

	//在开始解析之前，保存本次解析时State的起始位置
	public int begin() {
		if(this.tran == -1){
			this.tran = this.current;
		}
		return this.current;
	}

	public void commit(int tran) {
		if(this.tran == tran){
			this.tran = -1;
		}
	}

	//解析失败时，将begin方法中保存的本次解析时State的起始位置赋给current，即将State复位
	public void rollback(int tran) {
		if(this.tran == tran){
			this.tran = -1;
		}
		this.current = tran;
	}

}
