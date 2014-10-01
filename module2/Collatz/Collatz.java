package Collatz;

import java.io.PrintStream;
import java.util.Scanner;

public class Collatz {
	// Name 		: Antoni Stevenet
	// Assignment	: Collatz
	// Date 		: 2014-sep09-tue09

	PrintStream out;
	
	Collatz(){
		out = new PrintStream(System.out);
	}
	
	void Start(){
		Scanner in = new Scanner(System.in);
		
		out.print("Enter the starting number: ");
		int value = in.nextInt();
		
		while(value!=1){
			if(value % 2 == 0){
				value = value/2;
				out.print(value+" ");
			}
			else{
				value = 3 * value + 1;
				out.print(value+" ");
			}
		}
		
		in.close();
	}
	
	public static void main(String[] argv){
		new Collatz().Start();
	}
}
