package Electronics;

import java.util.Scanner;
import java.io.PrintStream;

public class Electronics {
	// Name 		: Antoni Stevenet
	// Assignment	: Electronics
	// Date 		: 2014-sep09-tue09

	PrintStream out;
	double reduction = 15;
	double maximum;
	
	Electronics(){
		out = new PrintStream(System.out);
	}
	
	void Start(){
		Scanner in = new Scanner(System.in);
		
		out.print("enter the price of the first article: ");
		double firstArticle = in.nextDouble();
		
		out.print("enter the price of the second article: ");
		double secondArticle = in.nextDouble();
		
		out.print("enter the price of the third article: ");
		double thirdArticle = in.nextDouble();

		if(firstArticle > secondArticle && firstArticle > thirdArticle) maximum = firstArticle;
		else if(secondArticle > firstArticle && secondArticle > thirdArticle) maximum = secondArticle;
		else maximum = thirdArticle;

		
		double discount = maximum * (reduction / 100); 		
		double total = firstArticle + secondArticle + thirdArticle - discount;
		
		out.printf("Discount: %.2f%n", discount);
		out.printf("Total: %.2f%n", total);
		
		in.close();
	}	
	public static void main(String[] argv){
		new Electronics().Start();
	}
}
