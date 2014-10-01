package Pirate;

import ui.UIAuxiliaryMethods;
import java.util.Scanner;
import java.io.PrintStream;

public class Pirate {
		// Name       : Antoni Stevenet
		// Assignment : Pirate
		// Date       : 2014-sep09-Tue30
	
	PrintStream out;
	private final int X_OFFSET = 1;
	private boolean addToFront = false;
	
	Pirate() {
		UIAuxiliaryMethods.askUserForInput();
		out = new PrintStream(System.out);
	}
	
	void Start() {
		Scanner in = new Scanner(System.in);
		in.useDelimiter("=");
		
		CoordinateRow resultRow = new CoordinateRow();
		
		while (in.hasNext()) {
			addToFront = addToFront? false : true;
			
			if (addToFront) resultRow.addRowToFront(getRow(in.next()));
			else resultRow.addRowToBack(getRow(in.next()));
		}
		
		printRow(resultRow);
		in.close();
	}
	
	CoordinateRow getRow(String nextRow) {
		CoordinateRow coordinateRow = new CoordinateRow();
		Scanner rowScanner = new Scanner(nextRow);
		
		rowScanner.useDelimiter("\\s");
		
		while (rowScanner.hasNext()) {
			Coordinate coordinate = getCoordinate(rowScanner.next());
			coordinateRow.addCoordinateToBack(coordinate);
		}
		rowScanner.close();
		return coordinateRow;
	}
	
	Coordinate getCoordinate(String coordinateString) {
		Scanner coordinateScanner = new Scanner(coordinateString);
		coordinateScanner.useDelimiter(",");
		
		return new Coordinate(coordinateScanner.nextInt() + X_OFFSET, coordinateScanner.nextInt());
	}
	
	void printRow(CoordinateRow coordinateRow) {
		for (int x = 0; x < coordinateRow.size ; x++) {
			out.println(coordinateRow.row[x].x + "," + coordinateRow.row[x].y);
		}
	}
	
	public static void main(String[] argv){
		new Pirate().Start();
	}
}
