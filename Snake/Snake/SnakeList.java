package Snake;

public class SnakeList {
	
	int MAX_NUMBER_OF_ELEMENTS = 50;
	int size = 0;
	Coordinate[] grid = new Coordinate[MAX_NUMBER_OF_ELEMENTS];
	
	void addCoordinateToFront(Coordinate coordinate) {
		for (int x = size - 2 ; x >= 0 ; x--) {
			grid[x+1] = grid[x];
		}
		grid[0] = coordinate;
		size++;
	}
	
	void addCoordinateToBack(Coordinate coordinate) {
		grid[size] = coordinate;
		size++;
	}
	
	Coordinate[] getRow() {
		return grid;
	}
	
}
