package hw4;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit tester file for the DoubleEndedLL class
 * 
 * @author Robert Chance
 * @since 2/2/16
 * @version 1.0
 * Login: cs12wam
 * PID: A13088857
 * 
 */
public class DoubleEndedLLTester {

	private static final int NUM_ELEMS = 7;
	
	DoubleEndedLL<Integer> nada, uno, mucho;
	
	
	/**
	 * Processes to be done before each test
	 * 
	 * @throws Exception No exceptions to be thrown
	 */
	@Before
	public void setUp() throws Exception {
		
		// Create 3 new lists to perform tests on
		nada = new DoubleEndedLL<Integer>();
		uno = new DoubleEndedLL<Integer>();
		mucho = new DoubleEndedLL<Integer>();
		
		// add one entry to list uno
		uno.addFirst( new Integer(2) );
		
		// add several entries to list mucho
		for( int i = 0 ; i <= NUM_ELEMS ; i++ ) {
			
			mucho.addFirst( new Integer(i) );
		}// end for
		
	}// end setUp()

	
	/**
	 * Tests that head nodes contain proper data
	 */
	@Test
	public void testGetHead() {
		
		// Test non-empty lists
		assertEquals("Check element 0", new Integer(2), uno.getHead() );
		assertEquals("Check element 0", new Integer(7), mucho.getHead() );
		
		// Test empty list
		try {
			assertEquals("Check element 0", new Integer(0), nada.getHead() );
			fail("This should throw an exception");
		}// end try
		
		catch( NullPointerException e ){
		
			// Normal
		}// end catch
		
	}// end testGetHead()

	
	/**
	 * Tests that tail nodes contain proper data
	 */
	@Test
	public void testGetTail() {
		
		// Test non-empty lists
		assertEquals("Check tail", new Integer(2), uno.getTail() );
		assertEquals("Check tail", new Integer(0), mucho.getTail() );
		
		// Test empty list
		try {
			
			assertEquals("Check tail", new Integer(0), nada.getTail() );
			fail("This should throw an exception");
		}// end try
		
		catch( NullPointerException e ) {
			
			// Normal
		}// end catch
	}
	
	
	/**
	 * Tests that list counters work properly
	 */
	@Test
	public void testIsEmpty() {
		
		assertEquals("Check empty list", true, nada.isEmpty() );
		assertEquals("Check uno list", false, uno.isEmpty() );
		assertEquals("Check mucho list", false, mucho.isEmpty() );
		
	}// end testIsEmpty()
	
	
	/**
	 * Tests that the list length is correct
	 */
	@Test
	public void testSize() {
		
		assertEquals("Check size of nada", 0, nada.size() );
		assertEquals("Check size of uno", 1, uno.size() );
		assertEquals("Check size of mucho", NUM_ELEMS + 1, mucho.size() );
		
	}// end testSize()
	
	
	/** 
	 * Tests addLast() and verifies correct data entered
	 */
	@Test
	public void testAddLast() {
		
		// add new value to end of each list
		nada.addLast( new Integer(42) );
		uno.addLast( new Integer(420) );
		mucho.addLast( new Integer(11) );
		
		// test those values
		assertEquals("Check last value of nada", new Integer(42), nada.getTail() );
		assertEquals("Check last value of uno", new Integer(420), uno.getTail() );
		assertEquals("Check last value of mucho", new Integer(11), mucho.getTail() );
			
	}// end testAddLast()
	
	
	/**
	 * Tests removeFirst() for proper implementation
	 */
	@Test
	public void testRemoveFirst() {
		
		// Remove first nodes from non-empty lists
		uno.removeFirst();
		mucho.removeFirst();
		
		// Test pointer for head in uno
		try{

			assertEquals("Check value of head", new Integer(0), uno.getHead() );
		}// end try
		
		catch( NullPointerException e ) {
			
			// Normal
		}// end catch
		
		// Test pointer for head in mucho and test removed value
		assertEquals("Check value of head", new Integer(6), mucho.getHead() );
		assertEquals("Check value that was removed", new Integer(6), mucho.removeFirst() );
		
		// Remove node from empty list
		try{
			
			nada.removeFirst();

		}// end try
		
		catch( NullPointerException e ) {
			
			// Normal
		}// end catch
		
	}// end testRemoveFirst()
	
	
	/**
	 * Tests removeLast() for proper implementation
	 */
	@Test
	public void testRemoveLast() {
		
		// Test non-empty lists
		uno.removeLast();
		mucho.removeLast();
		
		assertEquals("Check value of tail", new Integer(1), mucho.getTail() );
		assertEquals("Check value that was removed", new Integer(1), mucho.removeLast() );
		
		try {
			
			assertEquals("Check value of tail", new Integer(0), uno.getTail() );
			fail("This should have thrown an exception");
		}// end try
		
		catch( NullPointerException e ) {
			
			// Normal
		}// end catch
	}// end testRemoveLast()
}// end class DoubleEndedLLTester
