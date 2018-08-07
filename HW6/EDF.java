package hw6;
import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class EDF {

	public static void main(String[] args) {
		if(args.length != 1)
		{
			 System.err.println("Incorrect number of arguments: "+args.length);
			 System.err.println("java hw6.EDF <input-file>");
			 System.exit(1); 
		}
		File file = new File(args[0]);
		MyPriorityQueue<Record> queue = new MyPriorityQueue<Record>(10);
		long current_time=0;
		try{
			//your code goes here. 
		}
		catch(FileNotFoundException e)
		{
			System.err.println("Failed to open "+file);
			System.exit(1);
		}
		System.exit(0);
		
	}

}