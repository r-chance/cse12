package hw4;

/**
* @author Robert Chance
* @since 2/2/16
* @version 1.0
* Login: cs12wam
* PID: A13088857
* 
*/
public interface Stack_QueueInterface<T> {


/** Tests if the storage is empty. 
    * @return true a storage contains no items; false otherwise.
    */ 
public boolean isEmpty();

/** Adds an element to a storage 
    * @param newItem - item to be added
    */  
public void addElement(T newItem);

/** Removes the object from the storage and returns
    * that object as the value of this function.
    * @return value of the removed object.
    */  
public T removeElement();

/** Returns the size of the storage 
    * @return the size of the storage
    */ 
public int size();
 
}