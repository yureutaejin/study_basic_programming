public class LinkedBag<T> implements Bag<T> {
	private Node<T> bag; // Entry in bag
	private int numberOfEntries; // Linked to next node
	
	public LinkedBag() {
		bag = null; 
		numberOfEntries = 0;
	}
	
	public int getCurrentSize() {
		return numberOfEntries;
	}
	public boolean isFull() {
		return false;
	}
	public boolean isEmpty() {
		return numberOfEntries==0;
	}
	public boolean add(T newEntry) {	// OutOfMemoryError possible
		bag = new Node(newEntry, bag);
		numberOfEntries++;
		return false;
	}
	public T remove() {
		T result = null;
		if(bag != null) {
			result = bag.data;
			bag = bag.next;
			numberOfEntries--;
		}
		return result;
	}
	public boolean remove(T anEntry) {
		if(bag == null) return false; // case 1
		if(anEntry.equals(bag.data)) { // case 2
			bag = bag.next;
			numberOfEntries--;
			return true;
		}
		for(Node<T> p = bag ; p.next != null ; p = p.next) { // case 3
			if(anEntry.equals(p.next.data)) {
				p.next = p.next.next;
				numberOfEntries--;
				return true;
			}
		}
		return false;
	}
	public void clear() {
		bag = null;
		numberOfEntries = 0;
	}
	public int getFrequencyOf(T anEntry) {
		int counter = 0;
		for(Node<T> p = bag; p != null ; p=p.next) 
			if(anEntry.equals(p.data)) counter++;
			
		return counter;
	}
	public boolean contains(T anEntry) {
		boolean found = false;
		Node<T> p = bag;
		for(;!found && p != null ; p=p.next ) 
			found = anEntry.equals(p.data);
		return found;
	}	
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries];
		Node<T> p = bag;
		for(int i = 0 ; i < numberOfEntries && p != null ; p=p.next, i++) 
			result[i] = p.data;
		return result;
	}
	
	private class Node<T> {
		private T data;
		private Node<T> next;
		private Node(T x) {
			this(x, null);
		}// end constructor with field data
		private Node(T x, Node<T> n) {
			data = x;
			next = n;
		} // end constructor with field data and next value  
	} // end of inner class Node
} // end of class LinkedBag
