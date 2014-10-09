package NewSnake;

public class Walls {

	int MAX_NUMBER_OF_ELEMENTS = 300;
	int size = 0;
	Coordinate[] grid = new Coordinate[MAX_NUMBER_OF_ELEMENTS];
	
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
}
