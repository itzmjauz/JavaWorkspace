package NewSnake;

import java.io.PrintStream;
import ui.Event;
import ui.SnakeUserInterface;
import ui.UserInterfaceFactory;
import java.util.Scanner;
import ui.UIAuxiliaryMethods;

public class NewSnake {
	// Name       : Antoni Stevenet
	// Assignment : Snake
	// Date       : 2014-Oct10-Wed08
			
	SnakeUserInterface ui;
	PrintStream out;
			
	private static int WIDTH  			= 40;
	private static int HEIGHT 			= 30;
	private static int framerate 		= 12;	
	private static SnakeRow snakeRow 	= new SnakeRow(WIDTH,HEIGHT);
	private static Walls wallmap 		= new Walls();
	private static int direction 		= 0;;
	
	NewSnake() {
		ui = UserInterfaceFactory.getSnakeUI(WIDTH , HEIGHT);
		UIAuxiliaryMethods.askUserForInput();
		out = new PrintStream(System.out);
	}
	
	void Start() {
		Scanner readWalls = new Scanner(System.in);
		loadLevel(readWalls);
		snakeRow.generateFood(wallmap);
		
		drawBoard();
		ui.setFramesPerSecond(framerate);
		
		while(true) {
			Event event = ui.getEvent();
			processEvent(event);
		}
	}
	
	void processEvent(Event event) {
		out.println(event.data);
		
		if (snakeRow.gameOver == false) {
			if      (event.data=="R" && direction != 2) direction = 0;
			else if (event.data=="D" && direction != 3) direction = 1;
			else if (event.data=="L" && direction != 0) direction = 2;
			else if (event.data=="U" && direction != 1) direction = 3;
			else if (event.data=="refresh") {
				snakeRow.update(direction, wallmap);
				drawBoard();
			}
		}
	}
	
	void drawBoard() {
		ui.clear();
		
		for (int x = 0 ; x < wallmap.size ; x++) {
			ui.place(wallmap.grid[x].x, wallmap.grid[x].y, ui.WALL);
		}
		
		for (int x = 0 ; x < snakeRow.size ; x++) {
			ui.place(snakeRow.grid[x].x, snakeRow.grid[x].y, ui.SNAKE);
		}
		
		
		ui.place(snakeRow.food.x, snakeRow.food.y, ui.FOOD);
		ui.showChanges();
	}
	
	void initSnake(String initData) {
		Scanner initScanner = new Scanner(initData);
		
		snakeRow.addCoordinateToBack(new Coordinate(initScanner.nextInt(), initScanner.nextInt()));
		snakeRow.addCoordinateToBack(new Coordinate(initScanner.nextInt(), initScanner.nextInt()));
		
		initScanner.close();
	}
	
	void loadLevel(Scanner wallScanner) {
		wallScanner.useDelimiter("=");
		
		initSnake(wallScanner.next());
		setDirection(wallScanner.next());
		
		setWalls(wallScanner.next());
	}
	
	void setWalls(String wallData) {
		Scanner wallScanner = new Scanner(wallData);
		while(wallScanner.hasNextInt()) {
			Coordinate wall = new Coordinate(wallScanner.nextInt(), wallScanner.nextInt());
			wallmap.addCoordinateToBack(wall);
		}
		wallScanner.close();
	}
	
	void setDirection(String directionString) {
		if (directionString == "R")      direction = 0;
		else if (directionString == "D") direction = 1;
		else if (directionString == "L") direction = 2;
		else if (directionString == "U") direction = 3;
	}
	
	public static void main(String[] argv) {
		new NewSnake().Start();
	}
}
