package TheGameOfLife;

import ui.LifeUserInterface;
import ui.UserInterfaceFactory;
import ui.UIAuxiliaryMethods;
import java.util.Scanner;
import java.io.PrintStream;

public class TheGameOfLife {
	// Name       : Antoni Stevenet
	// Assignment : TheGameOfLife
	// Date       : 2014-sep09-Tue30

	
	private final static int WIDTH = 9;
	private final static int HEIGHT = 9;
	private static LifeUserInterface ui;
	private static int row;
	private static int[][] grid = new int[WIDTH][HEIGHT];
	private static int[][] nextGeneration = new int[WIDTH][HEIGHT];
	private static int generations = 0;
	private static int[][][] states;
	PrintStream out;
	
	TheGameOfLife() {
		ui = UserInterfaceFactory.getLifeUI(WIDTH, HEIGHT);
		UIAuxiliaryMethods.askUserForInput();
		out = new PrintStream(System.out);
	}
	
	void Start() {
		Scanner in = new Scanner(System.in);
		
		int maxGenerations = in.nextInt();
		int maxPeriod = in.nextInt();
		states = new int[maxGenerations][WIDTH][HEIGHT];
		
		while (in.hasNextLine()) {
			String nextLine = in.nextLine().replace(' ', '-');
			if (nextLine.length() != 0) {
				setup(nextLine, row);
				row++;
			}
		}
		
		save();
		updateBoard();
		while(generations < maxGenerations) {
			ui.wait(100);
			updateGrid();
			updateBoard();
			save();
			int p = check();
			if(p > 0) {
				if (p > 1) out.println("Halted, figure is : oscillator with p: " + p);
				else out.println("Halted , figure is : still figure");
				break;
			}
			generations++;
		}
		if(generations == maxGenerations) out.println("Halted, max number of generations reached");
	}
	
	private void save() {
		for (int x = 0 ; x < WIDTH ; x++) {
			for (int y = 0 ; y < HEIGHT ; y++) {
				states[generations][x][y] = grid[x][y];
			}
		}
	}
	
	private int check() {
		int pStatus = 0;
		for (int z = 0 ; z < generations ; z++) {
			pStatus = 0;
			for (int x = 0 ; x < WIDTH ; x++) {
				for (int y = 0 ; y < HEIGHT ; y++) {
					if (states[z][x][y] != states[generations][x][y]) pStatus = -1;
				}
			}
			if (pStatus == 0){
				pStatus = generations - z;
				break;
			}
		}
		return pStatus;
	}
	
	private void tick() {
		for (int x = 0 ; x < WIDTH ; x++) {
			for (int y = 0 ; y< HEIGHT ; y++) {
				if (grid[x][y] == ui.DEAD  && neighbours(x, y) == 3) nextGeneration[x][y] = ui.ALIVE;
				if (grid[x][y] == ui.ALIVE) {
					int neighbourCount = neighbours(x, y);
					if (neighbourCount == 2 || neighbourCount == 3) nextGeneration[x][y] = ui.ALIVE;
				}
			}
		}
	}
	
	private void updateBoard() {
		for (int x = 0 ; x < WIDTH ; x++) {
			for (int y = 0 ; y < HEIGHT ; y++) { 
				if (grid[x][y] == ui.ALIVE) {
					ui.place(x, y, ui.ALIVE);
				} else {
					ui.place(x, y, ui.DEAD);
				}
			}
		}
		ui.showChanges();
	}
	
	private void updateGrid() {
		tick();
		
		for (int x = 0 ; x < WIDTH ; x++) {
			for (int y = 0 ; y < HEIGHT ; y++) { 
				grid[x][y] = nextGeneration[x][y];
				nextGeneration[x][y] = ui.DEAD; // reset the nextGeneration list.
			}
		}
	}

	private int neighbours(int x,int y) {
		int result = 0;
		// check the corners
		if (x != 0 		&& y != 0 			 && grid[x-1][y-1] == ui.ALIVE) result++;
		if (x != 0 		&& y != HEIGHT-1	 && grid[x-1][y+1] == ui.ALIVE) result++;
		if (x != WIDTH-1 	&& y != 0 		 && grid[x+1][y-1] == ui.ALIVE) result++;
		if (x != WIDTH-1 	&& y != HEIGHT-1 && grid[x+1][y+1] == ui.ALIVE) result++;
		// check direct neighbours
		if (x != 0        && grid[x-1][y] == ui.ALIVE) result++;
		if (y != 0        && grid[x][y-1] == ui.ALIVE) result++;
		if (x != WIDTH-1  && grid[x+1][y] == ui.ALIVE) result++;
		if (y != HEIGHT-1 && grid[x][y+1] == ui.ALIVE) result++;
		
		return result;
	}
	
	private void setup(String nextRow, int row) {
		for (int x = 0 ; x < HEIGHT ; x++) {
			if (nextRow.charAt(x) == 'x') {
				//ui.place(y, row, ui.ALIVE);
				grid[x][row] = ui.ALIVE;
			} else {
				// Do nothing
			}
		}

		ui.showChanges();
	}
	public static void main(String[] argv) { 
		new TheGameOfLife().Start();
	}
}
