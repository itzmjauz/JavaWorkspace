package Piramid;

import java.io.PrintStream;

public class Piramid {
	// Name 		: Antoni Stevenet
	// Assignment	: Piramid
	// Date 		: 2014-sep09-tue16

  PrintStream out;
  
  static final int WIDTH = 80;
  static final int LEVELS = 15;
  static char currentCharacter = 'a';
  static int charactersToPrint = 1;

  Piramid() {
    out = new PrintStream(System.out);
  }

  void Start() {
    
    int whitespaces = WIDTH / 2;
    int iterator = 0;
    
    while (iterator < LEVELS){
    	
      printCharacters(whitespaces, ' ');
      printCharacters(charactersToPrint, currentCharacter);    
      out.println();
      
      currentCharacter++;
      iterator++;
      charactersToPrint += 2;
      whitespaces -= 1;
    }
  }
  
  void printCharacters(int amount, char character) {

	  for (int i = 0; i < amount ; i++) {
	    out.print(character);
	  }
  }

  public static void main(String[] argv){
    new Piramid().Start();
  }
}
