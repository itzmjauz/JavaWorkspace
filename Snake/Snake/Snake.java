package Snake;

import java.io.PrintStream;
import ui.Event;
import ui.SnakeUserInterface;
import ui.UserInterfaceFactory;

public class Snake {
	// Name       : Antoni Stevenet
	// Assignment : Snake3
	// Date       : 2014-Oct10-Wed08
		
	SnakeUserInterface ui;
	PrintStream out;
		
	private static int WIDTH  = 40;
	private static int HEIGHT = 30;
	private static int framerate = 24;	
	private static SnakeList snakeList = new SnakeList();
	private static int direction;
	
	Snake() {
		ui = UserInterfaceFactory.getSnakeUI(WIDTH , HEIGHT);
		//UIAuxiliaryMethods.askUserForInput();
		out = new PrintStream(System.out);
	}
		
	void Start(){
			
		ui.setFramesPerSecond(framerate);

		out.print("drew board");
		initSnake();
		drawBoard();
		while(true){
			Event event = ui.getEvent();
			processEvent(event);
		}
	}
	
	void processEvent(Event event){
		out.print("test");
	}
	
	void drawBoard(){
		ui.clear();
		
		for (int x = 0 ; x < snakeList.size ; x++){
			ui.place(snakeList.grid[x].x, snakeList.grid[x].y, ui.SNAKE);
		}
		
		ui.showChanges();
	}
	
	void initSnake(){
		snakeList.addCoordinateToBack(new Coordinate(0,0));
		snakeList.addCoordinateToBack(new Coordinate(0,1));
		direction = 0;
	}
	
	public static void main(String[] argv){
		new Snake().Start();
	}
}
