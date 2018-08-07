package hw4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tester to test DarkRoom class.  I used room1.txt for testing.
 * 
 * @author Robert Chance
 * @since 2/2/16
 * @version 1.0
 * Login: cs12wam
 * PID: a13088857
 */
public class DarkRoomTester {

	private DarkRoom room;
	
	@Before
	public void setUp() throws Exception {
		room = new DarkRoom();
		room.readFromFile("room1.txt");
	}

	/**
	 * JUnit tester to determine if method accurately returns true when 
	 * start location is tested.  Will also ensure that array was
	 * properly populated.
	 */
	@Test
	public void testFindStart() {
		
		assertEquals("Testing method returns proper value", true,
				      room.findStart().equals(new Location(2,6)));
	}// end testFindStart()

	
	
	/**
	 * JUnit tester to determine if method returns proper value
	 */
	@Test
	public void testIsDoor() {
		
		assertEquals("Testing door is properly identified", true,
				     room.isDoor(new Location(5,4)) );
	}// end testIsDoor()
	
	
	
	/**
	 * JUnit tester -- I edited the room to create a failure and a non-failure
	 *                 Gives IOOBE on small room dimensions
	 */
	@Test
	public void testCanMove() {
		
		assertEquals("Test that the location has no valid moves", false, 
				      room.canMove(new Location(1,6)) ); 
		assertEquals("Test that the location has valid moves", true,
				      room.canMove(new Location(1,1) ) );
				     
	}// end testCanMove()
	
	
	/** 
	 * markVisited() will be tested by marking locations around a single point
	 * until that location has no moves.
	 */
	@Test
	public void testMarkVisited() {
		
		assertEquals("Test that location has valid moves", true, 
				     room.canMove( new Location(2,2)) );
		
		// Mark every location around test location
		room.markVisited(new Location(1,2));
		room.markVisited(new Location(2,1));
		room.markVisited(new Location(3,2));
		room.markVisited(new Location(2,3));
		
		assertEquals("Same location should have no moves available", false,
				     room.canMove( new Location(2,2)) );
	}// end testMarkVisited()
	
	
	@Test
	public void testCountVisited() {
		
		assertEquals("Test that new room has no visited locations", 0,
				     room.countVisited() );
		
		room.markVisited(new Location(1,2));
		room.markVisited(new Location(2,1));
		
		assertEquals("Two spots should now be marked visited", 2,
				     room.countVisited() );
	}// end testCountVisited()
	
	
	
	/**
	 * Tests that clear() replaces all marked locations with unmarked,
	 * also ensures only visit markers are removed
	 */
	@Test
	public void testClear() {
		
		Location start = room.findStart();
		
        room.markVisited(new Location(2,1));
        room.markVisited(new Location(1,2));
        
        assertEquals("Test that 2 locations are marked", 2,
        		      room.countVisited() );
        
        room.clear();
        assertEquals("No locations should be marked", 0,
        		     room.countVisited() );
        assertEquals("Start location must not have been erased", 
        		     true, room.findStart().equals(start) );
        
	}// end testClear()
	
	
	
	/**
	 * Verify room is printed correctly, this is done by observation
	 */
	//@Test
	public void testPrintRoom() {
		
		room.printRoom();
		
	}// end testPrintRoom()
	
	
	
	@Test
	public void testEscapeDarkRoom() {
		
		room.escapeDarkRoom("Queue");
	}
	
}// end DarkRoomTester
