package LongestPath;

import java.io.PrintStream;
import ui.LabyrinthUserInterface;
import ui.UIAuxiliaryMethods;
import ui.UserInterfaceFactory;
import java.util.Scanner;

public class LongestPath {
	// Name       : Antoni Stevenet
	// Assignment : LongestPath
	// Date       : 2014-Oct10-Tue14

	private Coordinate end,
					   start;
	private int WIDTH = 32;
	private int HEIGHT = 24;
	private int length = 0;
	private boolean[][] longestPath;
	Walls wallMap = new Walls();

	PrintStream out;
	LabyrinthUserInterface ui;

	LongestPath() {
		UIAuxiliaryMethods.askUserForInput();
		ui = UserInterfaceFactory.getLabyrinthUI(WIDTH, HEIGHT);
		out = new PrintStream(System.out);
	}

	void Start() {
		Scanner mazeReader = new Scanner(System.in);
		mazeReader.useDelimiter("=");
		process(mazeReader);
		drawBoard();
		ui.showChanges();

		findPath(start, 0, new boolean[WIDTH][HEIGHT]);
		ui.printf("Longest path of length: %d\n",length);
		drawVisited(longestPath);
	}

	void process(Scanner mazeReader) {
		Scanner startReader = new Scanner(mazeReader.next());
		setStart(startReader);
		startReader.close();

		Scanner endReader   = new Scanner(mazeReader.next());
		setEnd(endReader);
		endReader.close();

		Scanner wallScanner = new Scanner(mazeReader.next());
		addWalls(wallScanner);
		wallScanner.close();

	}

	void addWalls(Scanner wallScanner) {
		while (wallScanner.hasNext()) {
			Coordinate nextWall = new Coordinate(wallScanner.nextInt(), wallScanner.nextInt());
			wallMap.addWall(nextWall);
		}
	}

	void setStart(Scanner startReader) {
		start = new Coordinate(startReader.nextInt(), startReader.nextInt());
	}

	void setEnd(Scanner endReader) {
		end = new Coordinate(endReader.nextInt(), endReader.nextInt());
	}

	void drawBoard() {
		for(int i = 0 ; i < wallMap.size ; i++) {
			ui.place(wallMap.grid[i].x, wallMap.grid[i].y, ui.WALL);
		}

		ui.place(start.x, start.y, ui.PATH);
		ui.encircle(end.x, end.y);
	}

	void drawVisited(boolean[][] visited) {
		ui.clear();
		drawBoard();
		for (int i = 0; i < visited.length ; i++) {
			for (int i2 = 0 ; i2 < visited[i].length ; i2++) {
				if(visited[i][i2]==true) ui.place(i, i2, ui.PATH);
			}
		}
		ui.wait(5);
		ui.showChanges();
	}

	void findPath(Coordinate point, int plength, boolean[][] visited) {
		plength++;

		boolean[][] nVisited = newVisited(visited);

		if (!wallMap.contains(point.x, point.y) && visited[point.x][point.y]!=true) {
			drawVisited(visited);
			nVisited[point.x][point.y] = true;

		} else {
			return;
		}

		if (point.x == end.x && point.y == end.y) {
			if  (length > plength) return;
			else {
				length = plength;
				longestPath = newVisited(nVisited);
				ui.printf("Most recent longest path found of length: %d\n",length);
				return;
			}
		}
		if (point.x>0) 	   findPath(new Coordinate(point.x-1, point.y), plength, nVisited);
		if (point.y<HEIGHT)findPath(new Coordinate(point.x, point.y+1), plength, nVisited);
		if (point.x<WIDTH) findPath(new Coordinate(point.x+1, point.y), plength, nVisited);
		if (point.y>0) 	   findPath(new Coordinate(point.x, point.y-1), plength, nVisited);
	}

	boolean[][] newVisited(boolean[][] visited) {
		boolean[][] nVisited = new boolean[WIDTH][HEIGHT];

		for (int x = 0 ; x < WIDTH ; x++) {
			for (int y = 0 ; y < HEIGHT ; y++) {
				nVisited[x][y] = visited[x][y];
			}
		}
		return nVisited;
	}

	public static void main(String[] argv) {
		new LongestPath().Start();
	}
}
