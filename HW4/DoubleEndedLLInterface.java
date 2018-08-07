package hw4;

/**
 * Interface providing structure for linked-list class
 * 
 * @author Robert Chance
 * @since 2/2/16
 * @version 1.0
 * Login: cs12wam
 * PID: A13088857
 * 
 */
public interface DoubleEndedLLInterface<T> {

/** Checks if the list is empty 
    * @return returns true if the list is empty, false otherwise
    */ 
    public boolean isEmpty();
 
/** Checks the size of the list 
    * @return returns the number of elements in the list
    */ 
    public int size();
 

/** Adds a new node to the front of the list 
    * @param newItem - an element to add
    */ 

    public void addFirst(T newItem);
 
/** Adds a new node to the end of the list 
    * @param newItem - an element to add
    */

    public void addLast(T newItem);

 /** Removes a node from the beginning of the list
    * @return element the data found
    * @throws NullPointerException
    */
 
    public T removeFirst();
  

/** Removes a node from the end of the list
    * @return element the data found
    * @throws NullPointerException
    */
    public T removeLast();
    
 
}