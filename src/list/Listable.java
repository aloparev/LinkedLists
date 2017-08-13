package list;

/**
 * @author Andrej Loparev 557966
 */
public interface Listable<T> {
	
	/**
	 * place composed element as the first
	 * @param data - the object added
	 */
	public void addToHead(T data);

	/**
	 * place composed element as the last
	 * @param data - the object added
	 */
	public void addToTail(T data);

	/**
	 * get a list-element (eg to print)
	 * @param index of the object to be fetched
	 */
	public T get(int index);

	/**
	 *  print all list-elements
	 */
	public void printAll();

	/**
	 * @return - list-size
	 */
	public int size();
	
	/**
	 * remove one list element
	 * @param index of the object to be removed
	 *
	 */
	public void del(int index);

	/**
	 * remove all list-elements
	 */
	public void delAll();

	/**
	 * replace an element with index i through given element
	 * @param i list-element-index
	 * @param element to be placed
	 */
	public void set(int i, T element);
}