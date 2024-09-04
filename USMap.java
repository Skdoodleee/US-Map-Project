/**
 *	Drawing a map of cities in the United States using StdDraw
 *
 *	@author Anthony He
 *	@since August 23, 2024
 */

import java.util.Scanner;

public class USMap{

	/**
	 * Sets up the canvas to be the right size, title, and scale
	 * @param				none
	 * @return 				the Scanner object to the file
	 */
	 
	public void setupCanvas() {
		StdDraw.setTitle("USMap");
		StdDraw.setCanvasSize(900, 512);
		StdDraw.setXscale(128.0, 65.0);
		StdDraw.setYscale(22.0, 52.0);
	}	
	
	/**
	 * Runs the program
	 * @param				none
	 * @return 				void
	 */
	
	public void runProg(){
		
		Scanner fileIn = FileUtils.openToRead("cities.txt");
		String lineInfo;
		int x[] = new in
		
		while(fileIn.hasNextLine()){
			System.out.println(fileIn.nextLine());
		}
		
	}
	
	
	
	
	public static void main(String[] args){
		USMap runner = new USMap();
		runner.runProg();
	}
}
