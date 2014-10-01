package VAT;

import java.util.Scanner;
import java.io.PrintStream;

public class VAT {
	// Name 		: Antoni Stevenet
	// Assignment	: VAT
	// Date 		: 2014-sep09-tue09

	PrintStream out;
	
	VAT(){
		out = new PrintStream(System.out);
	}
	
	void start(){
		Scanner in = new Scanner(System.in);
		
		out.printf("Enter the price of an article including VAT: ");
		
		double value = in.nextInt();
		double result = (value / 1.21);
		
		out.printf("This article will cost %.2f euro without 21.00 VAT%%.",result);
		
		in.close();
	}
	
	public static void main(String[] argv) {
		new VAT().start();
	}
}
