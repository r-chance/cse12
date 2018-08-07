package hw4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tester class for MyQueue class 
 * 
 * @author Robert Chance
 * @since 2/2/16
 * @version 1.0
 * Login: cs12wam
 * PID: A13088857
 * 
 */
public class MyQueueTester {

	private static final int NUM_ELEMS = 8;
	MyQueue<Integer> empty;
	MyQueue<Integer> one;
	MyQueue<Integer> many;
	MyQueue<String> sList;
	
	
	/**
	 * Processes to be done before each test
	 * 
	 * @throws Exception No exceptions to be thrown
	 */
	@Before
	public void setUp() throws Exception {
		
		// Create 3 Integer lists and 1 String list to test
		empty = new MyQueue<Integer>();
		one = new MyQueue<Integer>();
		many = new MyQueue<Integer>();
		sList = new MyQueue<String>();
		
		
		// add one entry to list one
		one.addElement(new Integer(4));
		
		// add multiple entries into list many
		for( int i = 0; i < NUM_ELEMS ; i++ ) {
			
			many.addElement(new Integer(i));
		}// end for
			
		// add multiple entries into list sList
		for( int i = 0; i < NUM_ELEMS ; i++ ) {
			
			sList.addElement( new String(""+i) );
		}// end for
		
	}// end setUp()

	
	/**
	 * Method for testing proper removal and return of data elements.
	 */
	@Test
	public void testRemoveElement() {
		
		// Test non-empty lists
		assertEquals("Test 1 element list", new Integer(4),
				     one.removeElement() );
		assertEquals("Test multi-element list", new Integer(0),
				     many.removeElement() );
		assertEquals("Test String list", new String("0"),
				     sList.removeElement() );
		// Test empty list
		assertEquals("Test empty list", null, empty.removeElement() );
					
		
	}// end testRemoveElement()

	
	
	/** 
	 * Method to test is list is empty
	 */
	@Test
	public void testIsEmpty() {
		
		assertEquals("Test non-empty list", false, one.isEmpty() );
		assertEquals("Test empty list", true, empty.isEmpty() );
		
	}// end testIsEmpty()
	
	
	/** 
	 * Method to test queue size
	 */
	@Test
	public void testSize() {
		
		assertEquals("Test empty list size", 0, empty.size() );
		assertEquals("Test non-empty list size", 1, one.size() );
		assertEquals("Test large list size", NUM_ELEMS, many.size() );
	}// end testSize()
}// end class MyQueueTester
