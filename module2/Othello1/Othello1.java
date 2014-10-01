package Othello1;

import java.util.Scanner;
import java.io.PrintStream;

public class Othello1 {
	// Name 		: Antoni Stevenet
	// Assignment	: Othello1
	// Date 		: 2014-sep09-tue09

	PrintStream out;
	double totalPieces = 64; 
	
	Othello1(){
		out = new PrintStream(System.out);
	}
	
	void start(){
		Scanner in = new Scanner(System.in);
		
		out.print("Enter the number of white pieces on the board: ");
		int whitePieces = in.nextInt();
		
		out.print("Enter the number of black pieces on the board: ");
		int blackPieces = in.nextInt();
		
		double piecesOnBoard = whitePieces + blackPieces;
		double blackPercentageOnBoard = (blackPieces / piecesOnBoard) * 100;
		double blackPercentageTotal = (blackPieces / totalPieces) * 100;
		
		out.printf("The percentage of black pieces on the board is: %.2f%%%n", blackPercentageTotal);
		out.printf("The percentage of black pieces of all the pieces on the board is: %.2f%%%n", blackPercentageOnBoard);
		
		in.close();
	}
	
	public static void main(String[] argv) {
		new Othello1().start();
	}
}
