package RepeatCharacter2;

import java.util.Scanner;
import java.io.PrintStream;

public class RepeatCharacter2 {
	// Name 		: Antoni Stevenet
	// Assignment	: RepeatCharacter2
	// Date 		: 2014-sep09-tue16
  
  PrintStream out;

  RepeatCharacter2() {
    out = new PrintStream(System.out);
  }

  void Start() {
    Scanner in = new Scanner(System.in);
    
    out.print("Enter the number of exclamation marks that you want to have printed: ");
    printCharacters(in.nextInt(), "!");
    out.print("Enter the number of commas that you wnat to have printed: ");
    printCharacters(in.nextInt(), ",");
    
    in.close();
  }
  
  void printCharacters(int amount, String character) {

	  for (int i = 0; i < amount ; i++) {
	    out.print(character);
	  }
	  
	  out.println();
  }

  public static void main(String[] argv) {
    new RepeatCharacter2().Start();
  }
}

