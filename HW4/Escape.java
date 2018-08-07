package hw4;

/**
 * Reads a file from command line args and calls the DarkRoom class to parse
 * that file and find the door in a room of obstacles.
 * 
 * @author Robert Chance
 * @since 2/2/16
 * @version 1.0
 * Login: cs12wam
 * PID: A13088857
 * 
 */
public class Escape {

	
	
	/**
	 * Reads args from command line and parses input file name
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String fname = args[0];
		DarkRoom room = new DarkRoom();
		room.readFromFile(fname);
		room.escapeDarkRoom("Stack");
		
	}// end main()

}// end class Escape
