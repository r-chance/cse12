package hw6;

/**
 * Interface for dHeap class.
 * 
 * @author Robert Chance
 * @since 2/17/16
 * @version 1.0
 *
 * @param <T> generic data type
 */
public interface dHeapInterface<T extends java.lang.Comparable<? super T>> {

	/**
	 * Adds the specified element to the heap; o cannot be null.
	 * 
	 * @param o the element to add.
	 */
	public abstract void add(T o );
	
	
	/**
	 * Removes and returns the smallest element stored in the heap.
	 * 
	 * @return the smallest element stored in the heap.
	 * 
	 * @throws if the heap is empty.
	 */
	public abstract T removeSmallest() throws java.util.NoSuchElementException;
	
	
	/**
	 * Returns the number of elements stored in the heap.
	 * 
	 * @return the number of elements stored in the heap.
	 */
	public abstract int size();
	
	
}
