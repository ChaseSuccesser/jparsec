package jparsec.kernel;

import java.io.EOFException;

/**
 * @author ligx
 *
 * @param <T> 解析结果的类型
 * @param <E> 输入流的类型
 */
public abstract class Parsec<T,E> {

	public abstract T parse(State<E> s) throws EOFException, ParsecException;
}
