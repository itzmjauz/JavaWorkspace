package NewSnake;

import ui.UIAuxiliaryMethods;

public class SnakeRow {
	int MAX_NUMBER_OF_ELEMENTS = 250;
	int size = 0;
	Coordinate[] grid = new Coordinate[MAX_NUMBER_OF_ELEMENTS];
	int width,height;
	Food food;
	boolean gameOver = false;
	
	SnakeRow(int nWidth, int nHeight){
		width = nWidth;
		height = nHeight;
	}
	
	void addCoordinateToFront(Coordinate coordinate) {
		for (int x = size - 1 ; x >= 0 ; x--) {
			grid[x+1] = grid[x];
		}
		grid[0] = coordinate;
		size++;
	}
	
	void addCoordinateToBack(Coordinate coordinate) {
		grid[size] = coordinate;
		size++;
	}
	
	boolean contains(int x ,int y){
		for(int i = 0 ; i < size ; i++){
			if(grid[i].x == x && grid[i].y == y){
				return true;
			}
		}
		return false;
	}
	
	Coordinate[] getRow() {
		return grid;
	}
	
	void generateFood(Walls wallmap){
		if(size==MAX_NUMBER_OF_ELEMENTS){
			System.out.println("maximum size reached");
		} else {
			int x = UIAuxiliaryMethods.getRandom(0,width);
			int y = UIAuxiliaryMethods.getRandom(0,height);
				
			if(contains(x,y) == false && wallmap.contains(x, y) == false ){
				food = new Food(x,y);
			} else {
				generateFood(wallmap);
			}
		}
	}
	
	void update(int direction, Walls wallmap){
		Coordinate nextHead = getNext(grid[0], direction);
		
		if (nextHead.x == food.x && nextHead.y == food.y){
			addCoordinateToFront(nextHead);
			generateFood(wallmap);
		} else if (collision(nextHead) || wallmap.contains(nextHead.x, nextHead.y)){
			gameOver = true;
		} else {
			for(int x = size - 1 ; x > 0 ; x--){ // map everything but the head to their next positions. 
				grid[x] = grid[x-1];
			}
			grid[0] = nextHead;
		}
	}
	
	boolean collision(Coordinate nextHead){
		for (int i = 0 ; i < size ; i++){
			if(grid[i].x == nextHead.x && grid[i].y == nextHead.y){
				return true;
			}
		}
		return false;
	}
	
	Coordinate getNext(Coordinate coordinate, int direction){
		int lastX = coordinate.x - 1,
			nextX = coordinate.x + 1,
			lastY = coordinate.y - 1,
			nextY = coordinate.y + 1;
		
		if (lastX == -1) 	 lastX = width - 1;
		if (nextX == width)  nextX = 0;
		if (lastY == -1)     lastY = height - 1;
		if (nextY == height) nextY = 0;
		
		if (direction == 0) 	 return new Coordinate(nextX, coordinate.y);
		else if (direction == 3) return new Coordinate(coordinate.x, lastY);
		else if (direction == 2) return new Coordinate(lastX, coordinate.y);
		else 					 return new Coordinate(coordinate.x, nextY);
	}
	
	void reset(){
		grid = new Coordinate[MAX_NUMBER_OF_ELEMENTS];
	}
}
