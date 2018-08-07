package hw4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tester file for MyStack class
 * 
 * @author Robert Chance
 * @since 2/2/16
 * @version 1.0
 * Login: cs12wam
 * PID: A13088857
 * 
 */
public class MyStackTester {

	private static final int HOW_BIG_THE_STACK = 15;
	
	MyStack<Integer> noStack, oneStack, bigStack;
	MyStack<String> wordStack;
	
	/**
	 * Processes to be done before each test
	 * 
	 * @throws Exception No exceptions to be thrown
	 */
	@Before
	public void setUp() throws Exception {
		
		// Create empty stack
		noStack = new MyStack<Integer>();
		
		// Create one item stack
		oneStack = new MyStack<Integer>();
		oneStack.addElement( new Integer(22) );
		
		// Create a multiple item stack for Integer and String
		bigStack = new MyStack<Integer>();
		wordStack = new MyStack<String>();
		for( int i = 0; i < HOW_BIG_THE_STACK; i++ ) {
			
			// Add value equal to index to each node
			bigStack.addElement( new Integer(i) );
		    wordStack.addElement( new String(""+i) );
			
		}// end for
	}// end setUp()

	
	/**
	 * Tests if stack is empty
	 */
	@Test
	public void testIsEmpty() {
		
		assertEquals("Test empty stack", true, noStack.isEmpty() );
		assertEquals("Test one node stack", false, oneStack.isEmpty() );
		assertEquals("Test multi-node stack", false, bigStack.isEmpty() );
		assertEquals("Test String stack", false, wordStack.isEmpty() );
	}// end testIsEmpty()

	
	
	/**
	 * Tests that elements added increment size and are the correct value
	 */
	@Test
	public void testAddElement() {
	
		// Test Integer stack
		noStack.addElement( new Integer(5) );
		assertEquals("Test that size was incremented with add", 1, 
				     noStack.size() );
		assertEquals("Test element added was correct value", new Integer(5),
				     noStack.removeElement() );
		
		// Test String stack
		wordStack.addElement( new String("Hello"));
		assertEquals("Test String is correct", "Hello", wordStack.removeElement() );
	}// end testAddElement()
	
	
	/**
	 * Tests that proper exceptions are thrown when removing nodes.
	 */
	@Test
	public void testRemoveElement() {
		
		// Normal cases have been shown above
		
		// Testing empty stack
		try {
			
			noStack.removeElement();
		}// end try
		
		catch(NullPointerException e) {
			// Normal
		}// end catch
	}// end testRemoveElement()
	
	
	
	/**
	 * Tests for proper sizes of stacks
	 */
	@Test
	public void testSize() {
		
		assertEquals("Test size of empty stack", 0, noStack.size() );
		assertEquals("Test size of one element stack", 1, oneStack.size() );
		assertEquals("Test size of multi-element stack", 15, bigStack.size() );
	}
	
	
	
}// end class MyStackTester
