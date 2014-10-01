package HelloWorld2;

import java.io.PrintStream;
import java.util.Scanner;

public class HelloWorld2 {
	// Name 		  : Antoni Stevenet
	// Assignment	: HelloWorld2
	// Date 		  : 2014-sep09-wed03

	PrintStream out;

	HelloWorld2() {
		out = new PrintStream(System.out);
	}

	void start() {
    Scanner in = new Scanner(System.in);

    out.print("Enter your name: ");
    String name = in.nextLine();

		out.printf("Hello world!! ");
		out.printf("written by: %s\n", name);
	}

	public static void main(String[] argv) {
		new HelloWorld2().start();
	}
}
