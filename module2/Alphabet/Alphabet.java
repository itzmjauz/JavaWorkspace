package Alphabet;

import java.io.PrintStream;

public class Alphabet {
	// Name 		: Antoni Stevenet
	// Assignment	: Alphabet
	// Date 		: 2014-sep09-tue09

	PrintStream out;

	Alphabet(){
		out = new PrintStream(System.out);
	}
	
	void Start(){
		for(char character = 'a';character<='z';character++){
			out.print(character);
		}
	}
	
	public static void main(String[] argv){
		new Alphabet().Start();
	}
}
