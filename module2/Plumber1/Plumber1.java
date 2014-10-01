package Plumber1;

import java.util.Scanner;
import java.io.PrintStream;

public class Plumber1 {
	// Name 		: Antoni Stevenet
	// Assignment	: Plumber1
	// Date 		: 2014-sep09-wed09

	PrintStream out;
	
	int callOutCost = 16;
	
	Plumber1(){
		out = new PrintStream(System.out);
	}
	
	void start(){
		Scanner in = new Scanner(System.in);
		
		out.print("Enter the hourly wages: ");
		double wages = in.nextDouble();
		
		out.print("Enter the number of billable hours: ");
		int hours = in.nextInt();
		
		double result = wages * hours + callOutCost;
		
		out.printf("The total cost of this repair is : $%.2f",result);
		
		in.close();
	}
	
	public static void main(String[] argv) {
		new Plumber1().start();
	}
}
