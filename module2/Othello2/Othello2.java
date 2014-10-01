package Othello2;

import java.io.PrintStream;
import java.util.Scanner;

public class Othello2 {
	// Name 		: Antoni Stevenet
	// Assignment	: Othello2
	// Date 		: 2014-sep09-tue09

	PrintStream out;
	
	Othello2(){
		out = new PrintStream(System.out);
	}
	
	void Start(){
		Scanner in = new Scanner(System.in);
		
		out.print("Enter the time the black player thought: ");
		int blackThinkTime = in.nextInt(); 
		
		out.print("Enter the time the white player thought: ");
		int whiteThinkTime = in.nextInt();
		
		int humanTime = Math.max(whiteThinkTime, blackThinkTime)/1000;
		int hours = Math.round(humanTime / 3600);
		int minutes = Math.round((humanTime % 3600)/60);
		int seconds = Math.round(humanTime % 60 );
		
		out.printf("The time the human player has spent thinking is: %02d:%02d:%2d%n",hours,minutes,seconds);
		
		in.close();
	}
	
	public static void main(String[] argv){
		new Othello2().Start();
	}
}
