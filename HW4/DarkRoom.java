package hw4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Class provides implementation to search a dark room for the door in a room
 * with walls and obstacles.
 * 
 * @author Robert Chance
 * @since 2/2/16
 * @version 1.0
 * Login: cs12wam
 * PID: A13088857
 * 
 */
public class DarkRoom implements DarkRoomInterface {

	public char [][] darkRoom;
    protected int numRows=0;
    protected int numCols;
    private int unexplored;
    
    /**
     * Reads input from file and parses the first two characters of the file
     * to use as dimensions for the char array. The char array is then populated.
     */
	public void readFromFile(String fname) {

		String line;// Stores the line from the file to be parsed
		BufferedReader inputStrem;// Reads a character stream and provides info
		StringTokenizer st;// Segments the string by whitespace


		try {
		    int currentRow = 0;// The row of the file to be parsed

		    // Create new BufferedReader to read file
		    inputStrem = new BufferedReader(new FileReader(fname));

		    // perform while line of file has data, also read input into line
		    while ((line = inputStrem.readLine()) != null) {
		    	
		    	// Perform if Rows haven't been set, reads dimensions of room
		    	if (numRows == 0) {
		    		
		    		// Create new StringTokenizer with first line of file
		    		st = new StringTokenizer(line);
		    		numRows = Integer.parseInt(st.nextToken());// First char
		    		numCols = Integer.parseInt(st.nextToken());// 2nd char
		    		
		    		// Set dimensions of room array from previous values
		    		darkRoom = new char[numRows][numCols];
		    		
		    	} else if (line.length() == 1)// Breaks loop if bad dimensions
		    		break;
		    	
		    	// If valid dimensions, populate darkroom array
		    	// executes to parse lines after dimensions line
		    	else {
		    		
		    		// Iterate each column of first row of room
		    		for (int c = 0; c < numCols; c++) {
		    			
		    			// set value of array by char parsed
		    			darkRoom[currentRow][c] = line.charAt(c);
		    		}
		    		currentRow ++;// incremement row
		    	}
		    }
		}
		// If no file is found
		catch (IOException e) {
			System.out.println (e.toString());// Print exception to console
			// Print error message
	        System.out.println("Could not find file " + fname);
		}

	}// end readFromFile()

	

	//Helper methods:

	// Method that returns the Location of "start"
	public Location findStart()
	{
		
		Location start;
		
		// i represents rows
		for( int i = 0; i < numRows; i++ ) {
			
			// j represents columns
			for( int j = 0 ; j < numCols ; j++ ) {
				
				if( darkRoom[i][j] == 'S' ) {
					
					start = new Location(i, j);
					return start;
				}// end if
			}// end for
		}// end for
		
		return null;// If no 'S' was found
	}// end findStart()

	
	
	/**
	 * Method that checks if the door was found
	 * 
	 * @return true if array location contains 'D'
	 */
	public boolean isDoor( Location loc )
	{
		
		return darkRoom[loc.getRow()][loc.getColumn()] == 'D';
	}// end isDoor()


	/**
	 * Checks if location is empty
	 * 
	 * @param loc location to be checked
	 * @return true if empty
	 */
	public boolean isEmpty( Location loc ) {
		
		return (darkRoom[loc.getRow()][loc.getColumn()] == ' ');
	}// end isEmpty()
	
	
	/**
	 * Method that checks if you can move
	 */
	public boolean canMove(Location loc)
	{
		// check up, left, right, down for valid moves
		
		return ( darkRoom[loc.getRow()][loc.getColumn() - 1] == ' ' ||
				 darkRoom[loc.getRow() - 1][loc.getColumn()] == ' ' ||
				 darkRoom[loc.getRow()][loc.getColumn() + 1] == ' ' ||
				 darkRoom[loc.getRow() + 1][loc.getColumn()] == ' ' );
	}// end canMove()

	
	
	/**
	 * Marks explored (visited) positions
	 */
	public void markVisited (Location loc)
	{
		
		darkRoom[loc.getRow()][loc.getColumn()] = '.';
		
	}// end markVisited()

	
	
	/**
	 * counts the number of visited positions
	 */
	public int countVisited()
	{
		
		int visited = 0;// counter for visited locations
		
		for( int i = 0; i < numRows ; i++ ) {

             for( int j = 0; j < numCols ; j++ ) {
            	 
            	 if( darkRoom[i][j] == '.' ) visited ++;
            	 
             }// end for
		}// end for
		
		return visited;
	}// end countVisited()

	
	
	/**
	 *  removes marks from visiting (removes '.')
	 */
	public void clear()
	{
		for( int i = 0; i < numRows ; i++ ) {
			
			for( int j = 0; j < numCols ; j ++ ) {
				
				if( darkRoom[i][j] == '.' ) {
					
					// replace any instance of '.' with ' ' (space)
					darkRoom[i][j] = ' ';
				}// end if
			}// end for
		}// end for
	}// end clear()

    /**
     * prints your array that represents a room
     */
	public void printRoom()
	{
        for( int i = 0; i < numRows ; i++ ) {
        	
        	for( int j = 0; j < numCols ; j++ ) {
        		
        		System.out.print(darkRoom[i][j]);
        		
        		if( j % (numCols - 1) == 0 && j != 0) {
            		
            		// New line at end of column
            		System.out.println("");
            	}// end if
        	}// end for
        }// end for
	  
	}// end printRoom()

	/**
	 *  Search for ESCAPE!!!
	 *  
	 *  @param choice - data structure to be used in search
	 */
    public void escapeDarkRoom(String choice){

    	Stack_QueueInterface<Location> storage;
    	Location currentLoc;
    	
    	int turns = 0;// counter for turns used in finding door
    	
    	
    	// Create new data structure based off of choice parameter
	    if("Stack".equals(choice) ) {
		   
	    	storage = new MyStack<Location>();
	    }// end if
	    
	    else if("Queue".equals(choice)) {
	    	
	    	storage = new MyQueue<Location>();
	    }// end else if
	    
	    else {
	    	
	    	storage = null;
	    	System.out.println("Invalid Choice");
	    	System.exit(0);
	    }// end else
	    
	    // Add starting element to data structure
	    storage.addElement( findStart() );
	    
	    // Remove start element from list to work with
	    currentLoc = storage.removeElement();
	    
	    // Iterate until currentLoc is door location
	    while( !isDoor(currentLoc)) {
	    	
	    	// If there are valid moves from current location
	    	if( canMove(currentLoc) ) {
	    		
	    		// Terminate if door is nearby
	    		if( isDoor( currentLoc.left() ) ||
	    			isDoor( currentLoc.up() ) ||
	    			isDoor( currentLoc.right() ) || 
	    			isDoor( currentLoc.down() ) )
	    			
	    			break;
	    		
	    		// Add valid locations to left of currentLoc
	    		if( isEmpty( currentLoc.left() ) )  {
	    
	    			storage.addElement(currentLoc.left());
	       			
	    		}// end if
	    		
	    		// Add valid locations above currentLoc
	    		if( isEmpty( currentLoc.up() ) ) {
	    		
	                storage.addElement(currentLoc.up());
	    		}// end if
	    		
	    		// Add valid locations to right of currentLoc
	    		if( isEmpty( currentLoc.right() ) ) {
	                    
	    			storage.addElement( currentLoc.right() );
	    		}// end if
	    		
	    		// Add valid locations below currentLoc
	    		if( isEmpty( currentLoc.down() ) ) {	
	    			                	    	
	    			storage.addElement( currentLoc.down() );
	    		}// end if
	    		
	    	}// end if
	    	
	        currentLoc = storage.removeElement();// Update currentLoc
	    	turns++;
	        
	    	
	    	//if( isDoor(currentLoc ) ) break; // Don't overwrite 'D' with next
	    	
	    	markVisited(currentLoc);// Marks over empty spaces with '.'
	    }// end while
	    
	    while( storage.size() > 0 ) {
	    	currentLoc = storage.removeElement();
	    	unexplored++;
	    }
	    
        printGoal( choice, turns, unexplored );	
        printRoom();

	// remember to call printRoom() after you call printGoal()
    }// end escapeDarkRoom()

	public void printGoal(String choice, int stepsTaken, int positionsLeft)
	{
		System.out.println("Goal found (with " + choice + "): It took "
					+ stepsTaken + " explored positions");
			System.out.println("There is (are) " + positionsLeft
					+ " position(s) left to explore in stack");

	}

}