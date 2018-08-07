package hw4;


/**
 * This class provides implementation for a queue based list
 * 
 * @author Robert Chance
 * @since 2/2/16
 * @version 1.0
 * Login: cs12wam 
 * PID: A13088857
 * 
 */
public class MyQueue<T> implements Stack_QueueInterface<T> {

	private static final int INI_SIZE = 8;
	
	private T[] list;
	private int capacity = INI_SIZE;// dynamic size of array
	private int size;// # elements in list
	private int head, tail;// index pointers
	
	
	/**
	 * 0-arg constructor creates default empty list
	 */
	@SuppressWarnings("unchecked")
	public MyQueue() {
		
		list = (T[])new Object[capacity];
		head = 0;
		tail = 0;
		size = 0;
	}// end MyQueue() ctor
	
	
	/**
	 * Doubles the array size if full
	 */
	@SuppressWarnings("unchecked")
	public void doubleCapacity() {
		
		capacity *= 2;// double array size
		
		// create new array with double capacity
		T[] temp = (T[])new Object[capacity];
		
		// index of new array
		int newCounter = 0;
		
		// Copy old array into new one
		for( int i = 0 ; i < size ; i++) {
		temp[newCounter] = removeElement();
		newCounter++;
		
		} 
	
		list = temp;

		// Reset list pointers
		head = 0;
		tail = size;
		
	}// end doubleSize()
	
	/**
	 * Returns true if list is empty
	 */
	public boolean isEmpty() {
		
		return size == 0;
	}// end isEmpty()
	
	
	/**
	 * Adds an element to the back of the list
	 */
	public void addElement( T newItem ) {
	
	    // if array is full
	    if( size == capacity ) {
			
			doubleCapacity();
	
		}// end if
		
	    // Add new item to end of list and move end of list
		list[tail++] = newItem;
		
		if( tail >= capacity ) tail = 0;
		
	    size++;

	}// end addElement()
	
	
	/**
	 * Removes an element from the front of the list; FIFO.
	 * 
	 * @return returns data from list head
	 */
	public T removeElement() throws NullPointerException {
		
		if( size != 0 ) {
			
	    	T data = (T)list[head];
		
	    	// Wrap index to front of list if head is at end of array
		    if( ++head == capacity ) {
			
			    head = 0; 
		    }// end if
		    
	    	size--;
		
	    	return data;
		}// end if
		
		else return null;
	}// end removeElement()
	
	
	/**
	 * Returns the size of the list
	 * 
	 * @returns returns list size
	 */
	public int size() {
		
		return size;
	}// end size()
}// end class MyQueue
