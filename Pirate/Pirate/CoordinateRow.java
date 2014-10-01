package Pirate;

public class CoordinateRow {
	
	int MAX_NUMBER_OF_ELEMENTS = 20;
	int size = 0;
	Coordinate[] row = new Coordinate[MAX_NUMBER_OF_ELEMENTS];
	 
	void addRowToBack(CoordinateRow coordinateRow) {
		for (int x = 0; x < coordinateRow.size ; x++) {
			row[x + size] = coordinateRow.row[x];
		}

		size += coordinateRow.size;
	}
	
	void addRowToFront(CoordinateRow coordinateRow) {
		for (int x = row.length-1 ; x >= 0 ; x--) {
			if(row[x] != null) row[x + coordinateRow.size] = row[x];
		}
		for (int x = 0 ; x < coordinateRow.size ; x++) {
			row[x] = coordinateRow.row[x];
			size++;
		}
	}

	void addCoordinateToFront(Coordinate coordinate) {
		for (int x = size - 2 ; x >= 0 ; x--) {
			row[x+1] = row[x];
		}
		row[0] = coordinate;
		size++;
	}
	
	void addCoordinateToBack(Coordinate coordinate) {
		row[size] = coordinate;
		size++;
	}
	
	Coordinate[] getRow() {
		return row;
	}
	
}
