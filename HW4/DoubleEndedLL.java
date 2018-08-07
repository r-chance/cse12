package hw4;


/** 
 * Class provides implementation for a double ended linked list based queue.
 * 
 * @author Robert Chance
 * @since 2/2/16
 * @version 1.0
 * Login: cs12wam
 * PID: A13088857
 * 
 */
public class DoubleEndedLL<T> implements DoubleEndedLLInterface<T> {

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
     * Checks if list is empty
     * 
     * @return returns true if list is empty
     */
    public boolean isEmpty() {
    	
    	return length == 0;
    }// end isEmpty()
    
    
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
     * Adds a new node to the end of the list
     * 
     * @param newItems - an element to add
     */
    public void addLast( T newItem ) {
    	
    	Node temp;
    	
        if( length == 0 ) {
        	
        	head = new Node( newItem );
        	tail = head;
        	length++;
        }// end if
    	
        else {
        
        	temp = tail;
    	    tail = new Node( newItem );
    	    temp.setNext( tail );
    	    length++;
        }// end else
    }// end addLast()
    
    
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

    
    /** 
     * Removes a node from the end of the list
     * 
     * @return data at given node
     * @throws NullPointerException
     */
    public T removeLast() throws NullPointerException {
    	
    	Node temp;
    	T removed;
    	removed = tail.getElement();
    	
    	if( head == tail ) {
    		
    		head = null;
    		tail = null;
    		length--;
    		
    	}// end if
    	
    	else {
    	
    		temp = head;// starting point to cycle through nodes
    		
    		while( temp.getNext() != tail ) {
    		
    		    temp = temp.getNext();
    			
    		}// end while loop
    		temp.setNext(null);
    		
    		tail = temp;
    		length--;
    				
    	}// end else
    	
    	return removed;
    }// end removeLast()
    
    
    /** 
     * Returns value of head node
     * 
     * @return returns head
     */
    public T getHead() {
    	
    	return head.getElement();
    }// end getHead()
    
    
    /** 
     * Returns value of tail node
     * 
     * @return returns tail
     */
    public T getTail() {
    	
    	return tail.getElement();
    }// end getTail()
}// end class DoubleEndedLL
