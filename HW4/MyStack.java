package hw4;


/**
 * This class provides implementation for a stack based list.
 * 
 * @author Robert Chance
 * @since 2/2/16
 * @version 1.0
 * Login: cs12wam
 * PID: A13088857
 * 
 */
public class MyStack<T> implements Stack_QueueInterface<T> {

	// Create a new list to build the stack in
	private DoubleEndedLL<T> stack;
	
	/**
	 * 0-arg constructor for creating a default stack.
	 */
	public MyStack() {
		
		stack = new DoubleEndedLL<T>();
	}// end MyStack() constructor
	
	
	/**
	 * Method invokes LL member method to return size of stack
	 */
	public boolean isEmpty() {
		
		return stack.size() == 0;
	}// end isEmpty()
	
	
	/**
	 * Pushes an element to the top of the stack
	 */
	public void addElement( T newItem ) {
		
		// Add element to top of stack always
		stack.addFirst( newItem );
	}// end addElement()
	
	
	
	/**
	 * Pops an element from the top of the stack
	 */
	public T removeElement() {
		
		// Always FILO
		return stack.removeFirst();
	}// end removeElement()
	
	
	/**
	 * Invokes LL member class to return size of stack
	 */
	public int size() {
		
		return stack.size();
	}// end size()
	
	
	/* INNER CLASSES */
	
	
	/**
	 * Inner class to provide a data structure to build the stack on.
	 */
	
	@SuppressWarnings("hiding")
	private class DoubleEndedLL<T>  {

		private int length;
		Node head;
		Node tail;
			
		/**
		 * Inner class creates Nodes within list
		 */
		private class Node {
		
			T data;// Data to be entered at node
			Node next;// The succeeding node
			
			
			/** Constructor for adding single node */
			public Node( T contents ) {
			
					
				setElement( contents );
				setNext(null);
					
				
				
			}// end Node ctor
			
			
			/**
			 * Method to link next node
			 * 
			 * @param n succeeding node
			 */
			public void setNext( Node n ) {
				
				next = n;	
			}// end setNext()
			
			
			/** 
			 * Returns pointer to next node
			 * 
			 * @return next node
			 */
			public Node getNext() {
				
				return next;
			}// end getNext()
			
			
			/**
			 * Method to set data to node
			 * 
			 * @param t data to set
			 */
			public void setElement( T t ) {
				
				data = t;		
			}// end setElement()
			
			
			/**
			 * Returns value of element 
			 *
			 * @return returns element data
			 */
			public T getElement() {
				
				return data;
			}// end getElement()
		}// end inner class Node
		
		/* END OF INNER CLASS NODE */
		
		
		
		/**
		 * Default no-arg constructor
		 */
		public DoubleEndedLL() {
			
			length = 0;
			head = null;
			tail = null;
		}// end ctor DoubleEndedLL()
		
		
	    
	    /**
	     * Checks the size of the list
	     * 
	     * @return returns the number of list elements
	     */
	    public int size() {
	    	
	    	return length;	
	    }// end size()
	    
	    
	    /**
	     * Adds a new node to the front of the list
	     * 
	     * @param newItem - an element to add
	     */
	    public void addFirst( T newItem ) {

	    	if( length == 0 ) {
	    		
	    		head = new Node( newItem );
	    		tail = head;
	    		length++;
	    	}// end if
	    	
	    	else {
	    		
	    		Node temp = head;
	    		
	    		head = new Node( newItem );
	    		head.setNext( temp );
	    		length++;
	    	}// end else
	    
	    }// end addFirst()
	    
  
	    
	    /**
	     * Removes a node from the beginning of the list.
	     * 
	     * @return element the data found
	     * @throws NullPointerException
	     */
	    public T removeFirst() throws NullPointerException {
	    	
	    	T removed;
	    	removed = head.getElement();
	    	
	    	if( head == tail ) {
	    		
	    		head = null;
	    		tail = null;
	    		length--;
	    	}// end if
	    	
	    	else {
	    		
	    	    head = head.getNext();
	    	    length--;
	    	}// end else
	    	
	    	return removed;
	    }// end removeFirst()	   
	}// end class DoubleEndedLL

    /* END INNER CLASSES */	
	
	
	
}
