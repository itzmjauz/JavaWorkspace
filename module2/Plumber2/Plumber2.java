package Plumber2;

import java.util.Scanner;
import java.io.PrintStream;

public class Plumber2{
	// Name 		: Antoni Stevenet
	// Assignment	: Plumber2
	// Date 		: 2014-sep09-tue09

	PrintStream out;
	int callOutCost = 16;
	
	Plumber2(){
		out = new PrintStream(System.out);
	}
	
	void start(){
		Scanner in = new Scanner(System.in);
		
		out.print("Enter the hourly wages: ");
		double wages = in.nextDouble();
		
		out.print("Enter the number of hours worked: ");
		double hours = Math.round(in.nextDouble());
		
		double result = wages * hours + callOutCost;
		
		out.printf("The total cost of this repair is : $%.2f",result);
		
		in.close();
	}
	
	public static void main(String[] argv) {
		new Plumber2().start();
	}
}
