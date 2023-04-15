package edu.collin.cosc2436.ThanhTran.shoppingList;

public interface MyList<T> extends Iterable<T>{
	public boolean isEmpty();
	void addFirst(T element);

	/**
	 * Adds an element to the end of the list
	 * 
	 * @param element The element to add
	 */
	void addLast(T element);
	public boolean remove(T element);
	
}
