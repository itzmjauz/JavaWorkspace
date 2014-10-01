package RepeatCharacter1;

import java.util.Scanner;
import java.io.PrintStream;

public class RepeatCharacter1 {
	// Name 		: Antoni Stevenet
	// Assignment	: RepeatCharacter1
	// Date 		: 2014-sep09-tue16
	
	PrintStream out;
	
	RepeatCharacter1(){
		out = new PrintStream(System.out);
	}
	
	void Start(){
		Scanner in = new Scanner(System.in);
		out.print("Enter the number of Exclamation marks that you want to have printed: ");
		printExclamationMarks(in.nextInt());
		
		in.close();
	}
	
	void printExclamationMarks(int amount){
		
		for(int i = 0 ; i < amount ; i++){
			out.print("!");
		}
	}
	
	public static void main(String[] argv){
		new RepeatCharacter1().Start();
	}
}
