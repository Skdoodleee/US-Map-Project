/**
 *	Drawing a map of cities in the United States using StdDraw
 *
 *	@author Anthony He
 *	@since September 4, 2024
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
		Scanner bigCities = FileUtils.openToRead("bigCities.txt");
		double latitude, longitude;
		String[] nameAndInitial = new String[1200];
		double[] lat = new double[1200], lon = new double[1200];
		String nAndI, cityName;
		int cIndex = 0, population, counterTopTen = 0;
		
		nameAndInitial[0] = "";
		
		setupCanvas();
		StdDraw.setPenRadius(0.006);
		StdDraw.setPenColor(StdDraw.GRAY);
		
		//color in all cities first
		while(fileIn.hasNextLine()){
			latitude = fileIn.nextDouble();
			longitude = fileIn.nextDouble();
			nAndI = fileIn.nextLine().trim();
			if(!nameAndInitial[Math.max(cIndex-1, 0)].equals(nAndI)){
				nameAndInitial[cIndex] = nAndI;
				lat[cIndex] = latitude;
				lon[cIndex] = longitude;
				cIndex++;
			}
			StdDraw.point(longitude, latitude);
		}
		//color in big cities in blue/red
		while(bigCities.hasNextLine()){
			bigCities.nextInt();
			cityName = bigCities.nextLine();
			//find population using parseInt
			population = Integer.parseInt(cityName.substring(cityName.lastIndexOf(" ")).trim());
			//find city name and initials
			cityName = cityName.substring(0,cityName.lastIndexOf(" ")).trim();
			
			//determine color of the big dot.
			if(counterTopTen >= 10){
				StdDraw.setPenColor(StdDraw.BLUE);
			}
			else{
				StdDraw.setPenColor(StdDraw.RED);
				counterTopTen++;
			}
			
			//check for city location
			for(int i=0;i<cIndex; i++){
				if(cityName.equalsIgnoreCase(nameAndInitial[i])){
					StdDraw.setPenRadius(0.6 * (Math.sqrt(population)/18500));
					StdDraw.point(lon[i], lat[i]);
				}
			}
		}
		
	}
	
	
	
	
	public static void main(String[] args){
		USMap runner = new USMap();
		runner.runProg();
	}
}
