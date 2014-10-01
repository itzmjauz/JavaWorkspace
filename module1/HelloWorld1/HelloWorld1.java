package HelloWorld1;

import java.io.PrintStream;

public class HelloWorld1 {
	// Name 		: Antoni Stevenet
	// Assignment	: HelloWorld1
	// Date 		: 2014-sep09-wed03

	PrintStream out;

	HelloWorld1() {
		out = new PrintStream(System.out);
	}

	void start() {
		out.printf("Hello world!! ");
		out.printf("written by: %s\n", "Antoni Stevenet");
	}

	public static void main(String[] argv) {
		new HelloWorld1().start();
	}
}
