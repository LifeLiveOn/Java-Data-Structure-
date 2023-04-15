package edu.collin.cosc2436.ThanhTran.shoppingList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements MyList<T>{
	private Node<T> first = null;
	private Node<T> last = null;
	private int size = 0;
	
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return  new MyIterator();
	}

	@Override
	public boolean isEmpty() {
		
		return size==0;
	}

	@Override
	public void addFirst(T element) {
		Node<T> nodeFirst = new Node<T>(element);
		nodeFirst.setNext(first);
		first = nodeFirst;
		if(last==null) {
			last = nodeFirst;
		}
		size++;
		
		
	}

	@Override
	public void addLast(T element) {
		Node<T> nodeLast = new Node<T>(element);
		nodeLast.setNext(null);
		if(last!=null) {
			last.setNext(nodeLast);
		}
		last = nodeLast;
		if(first==null) {
			first= nodeLast;
		}
		size++;
		
	}

	@Override
	public boolean remove(T element) {
		 
		Iterator<T> current = iterator(); 
		while(current.hasNext()) {
			if(current.next().equals(element)) {
//				T ret = element;
				current.remove();
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * An inner class implementation of this list's iterator
	 */
	private class MyIterator implements Iterator<T> {
		private Node<T> current;
		private Node<T> previous;
		private boolean canRemove;

		/**
		 * Constructs the iterator
		 */
		public MyIterator() {
			Node<T> node = new Node<T>(null);
			node.setNext(first);
			current = node;
			previous = node;
			canRemove = false; // can't remov nodee when initialize constructor
		}

		/**
		 * Tests if the iteration has more elements
		 * 
		 * @return true if the iteration has more elements and false otherwise
		 */
		@Override
		public boolean hasNext() {
			return current.getNext()!=null;
		}

		/**
		 * Returns the next element in the iteration.
		 *
		 * @return the next element in the iteration
		 * @throws NoSuchElementException if the iteration has no more elements
		 */
		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			previous = current;
			current = current.getNext();
			canRemove = true;
			return current.getValue();
		}

		/**
		 * Removes the last element returned by this iterator from the underlying list.
		 * This method can be called only once per call to next().
		 *
		 * @throws IllegalStateException if the next() method has not yet been called,
		 *                               or the remove() method has already been called
		 *                               after the last call to the next() method
		 */
		@Override
		public void remove() {
			if (!canRemove) {
				throw new IllegalStateException("remove has been call previously or next() has not been cal");
			}
			// when we want to remove the first node.
			if (first == current) {
				// this will work even if first is the only node in the list; 
				first = current.getNext(); //next of current could be null;
			}
			//when we want to remove the last node
			if (last == current) {
				if (first == null) { // if list is empty;
					last = null;
				} else {
					last = previous;
				}
			}
			//remove the middle node;
			previous.setNext(current.getNext()); 
			current = previous; // move the pointer of current to previous and current.nex
			canRemove = false; // we already remove it to deduct size, reset the boolean field;
			size--;
		}
	}
	
	
	/**
	 * A static nested class implementation of the node 
	 *
	 * @param <T> The type of value the node contains
	 */
	private static class Node<T> {
		private final T value;
		private Node<T> next;

		/**
		 * Constructs a node with a given value
		 * 
		 * @param value The value for the node instance
		 */
		public Node(T value) {
			this.value = value;
		}

		/**
		 * Getter for the next node to this node
		 * 
		 * @return The successor node
		 */
		public Node<T> getNext() {
			return next;
		}

		/**
		 * Setter for the next node to this node
		 * 
		 * @param next The new successor node
		 */
		public void setNext(Node<T> next) {
			this.next = next;
		}

		/**
		 * Getter for the value
		 * 
		 * @return The node's value
		 */
		public T getValue() {
			return value;
		}
	}

}
