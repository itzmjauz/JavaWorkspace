package Replay1;

import ui.OthelloReplayUserInterface;
import ui.UserInterfaceFactory;
import ui.UIAuxiliaryMethods;
import java.util.Scanner;

public class Replay1 {
	// Name       : Antoni Stevenet
	// Assignment : Replay1
	// Date       : 2014-sep09-Tue16

	private static OthelloReplayUserInterface ui;
	private static int currentPlayer;

	Replay1() {
		ui = UserInterfaceFactory.getOthelloReplayUI();
		UIAuxiliaryMethods.askUserForInput();
	}

	void Start() {
		Scanner in = new Scanner(System.in);
		init(); // load initial state

		while (in.hasNext()) {
			Scanner inputLine = new Scanner(in.nextLine());
			process(inputLine);
			//lastly update the board
			ui.showChanges();
		}
		in.close();
	}

  private void process(Scanner inputLine){
    // first check who the current player is
		if (inputLine.next().equals("black")) currentPlayer = ui.BLACK;
		else currentPlayer = ui.WHITE;

		// and wait for the thinking time
		ui.wait(inputLine.nextInt());

		// check pass/move ; ui.place needs [x] [y] [player]  (x) is originally a letter, but place wants it as a number.
		if (inputLine.next().equals("move")) ui.place(stringToCord(inputLine.next()), inputLine.nextInt()-1, currentPlayer);
  }

	private void init() { // initialize the starting phase
		ui.place(3, 3, ui.WHITE);
		ui.place(4, 4, ui.WHITE);
		ui.place(3, 4, ui.BLACK);
		ui.place(4, 3, ui.BLACK);

		ui.showChanges();
	}

	private int stringToCord(String character) {
		// Get the char from the string ( turning it into a type char ) then cast it to a type int
		return (int)(character.charAt(0) - 'a');
	}

	public static void main(String[] argv) {
		new Replay1().Start();
	}
}
