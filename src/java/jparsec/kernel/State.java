package jparsec.kernel;

import java.io.EOFException;

public interface State<E> {

	E next() throws EOFException;
	
	int index();
	
	int begin();
	
	void commit(int tran);
	
	void rollback(int tran);
}
