package hw6;

import java.util.*;


class dHeap <T extends Comparable <? super T>> implements dHeapInterface<T> {
		
	private static final int INI_SIZE = 8;
	
	private T[] array;
	private int elements;// number of elements in heap
	
	//The constructor  takes one argument: an initial capacity
	//Used when binary heap is needed.
	public dHeap (int heapSize)
    {
	    array = (T[]) new Comparable[heapSize];
	}

	//The constructor takes two arguments: an initial capacity
	//and the number of children, d
	//if d is less than one, throw IllegalArgumentException();
	public dHeap (int d, int heapSize) { 
		
		array = (T[]) new Comparable[heapSize];
	}

	public int size () {  }
	
	
	/**
	 * Adds an element to the heap, increasing the size of the array if needed.
	 */
	public void add (T data) {  
		
		// Expand array if need be
		if( elements == array.length ) {
			
		    doubleSize( array.length );
		}// end if
		
		if( data.compareTo( this. ))
		
	}

		
	public T removeSmallest () { }

	private void trickleDown( int index ) {
		
	}
	
	private void bubbleUp( int index ) {
		
	}
	
	/**
	 * Doubles the size of the current array
	 * 
	 * @param oldSize the size of the old array
	 */
	private void doubleSize( int oldSize ) {
		
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Comparable[2*oldSize];
		
		for( int i = 0; i < oldSize ; i++ ) {
			
			temp[i] = array[i];
		}
		
		array = temp;
	}
	
	
	
	
}