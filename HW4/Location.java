package hw4;

/**
 * A class to store a location as an object.
 * 
 * @author Robert Chance
 * @since 2/2/16
 * @version 1.0
 * Login: cs12wam
 * PID: A13088857
 * 
 */
public class Location {

	protected int row; // The row an element is contain within
	protected int column;// The column an element is contained within

	   /**
	    * Constructor sets value of Location object with data passed in.
	    * 
	    * @param currRow The row the element is in
	    * @param currCol The column the element is in
	    */
	   public Location(int currRow, int currCol) {
		   
	      row = currRow; // set value for row
	      column = currCol; // set value for column
	   }

	   
	   /**
	    * Returns the Location's row
	    * 
	    * @return row
	    */
	   public int getRow() {
		   
	      return row; // return row
	   }
	   
	   /**
	    * Returns the Location's column
	    * 
	    * @return column
	    */
	   public int getColumn() {
		   
	      return column; // return column
	   }

	   
	   /* LEFT, UP, RIGHT, DOWN */
	   
	   /**
	    * Returns the Location immediately to the left of the current Location.
	    *  
	    * @return Location to left
	    */
	   public Location left() {
		   
		     return new Location(row,column-1);// Returns Location to left
	   }
	   
	   
	   /**
	    * Returns the Location Immediately above the current Location.
	    * 
	    * @return Location above
	    */
	   public Location up() {
		   
	      return new Location(row-1,column);// Returns Location above
	   } 
	   
	   
	   /**
	    * Returns the Location immediately to the right of the current one. 
	    * 
	    * @return Location to the right
	    */
	   public Location right() {
		      return new Location(row,column+1);   
	      
	   }
	   
	   /** 
	    * Returns the Location immediately below the current Location.
	    * 
	    * @return Location below
	    */
	   public Location down() {
		   
	      return new Location(row+1,column); // Returns Location below
	   }

	   /**
	    * Method to check match of two locations
	    * @Override gave an error, although I don't believe it should have
	    * 
	    * @param l location to be check against this Location
	    * @return true if location is match
	    */
	   public boolean equals(Location l) {
		   
		   return l.getRow() == this.getRow() && 
				  l.getColumn() == this.getColumn();
	   }// end equals()

	
}
