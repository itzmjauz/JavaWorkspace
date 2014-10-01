package Manny;

import java.io.PrintStream;
import java.util.Scanner;

public class Manny {
	// Name 		: Antoni Stevenet
	// Assignment	: Manny
	// Date 		: 2014-sep09-tue09

	PrintStream out;
	boolean amountExceeded = false;
	
	Manny(){
		out = new PrintStream(System.out);
	}
	
	void Start(){
		Scanner in = new Scanner(System.in);
		
		do{
			out.print("Enter the amount you want to donate: ");
			double amount = in.nextDouble();
			
			if(amount > 50){
				out.printf("Thank you very much for your contribution of %.2f euro %n", amount);
				amountExceeded=true;
			}
		}while(!amountExceeded);
		
		in.close();
	}
	
	public static void main(String[] argv){
		new Manny().Start();
	}
}
