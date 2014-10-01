package Statistics;

import ui.UIAuxiliaryMethods;
import ui.BarChartUserInterface;
import ui.UserInterfaceFactory;

import java.util.Scanner;
import java.io.PrintStream;

public class Statistics {
	// Name       : Antoni Stevenet
	// Assignment : Statistics
	// Date       : 2014-sep09-Wed24
	
	static final int NUMBER_OF_BARS = 10;
	static final int OFFSET = 5;
	BarChartUserInterface barChart;
	PrintStream out;
	
	Statistics() {
		barChart = UserInterfaceFactory.getBarChartUI(NUMBER_OF_BARS);
		UIAuxiliaryMethods.askUserForInput();
		out = new PrintStream(System.out);
	}
	
	void Start() {
		Scanner in = new Scanner(System.in);
		barChart.setShowNames(true);
		barChart.setShowValues(true);
		
		nameBars();
		
		while(in.hasNext()) {
			Scanner nextLine = new Scanner(in.nextLine());
			nextLine.useDelimiter("\\t");
			processLine(nextLine);
		}
		barChart.showChanges();
	}
	
	void processLine(Scanner nextLine) {
		while (nextLine.hasNext()) {
			Scanner nextTab = new Scanner(nextLine.next());
			processTab(nextTab);
		}
	}
	
	void processTab(Scanner nextTab) {
		if (nextTab.hasNextInt()) {
			nextTab.nextInt(); //call to get the next integer ( which we don't use ) can either be a year or thinking time
			if (nextTab.hasNextInt()) processValue(nextTab.nextInt()); // this way we wont get an error if the first int was the year 
		}
	}
	
	void processValue(double percentage) {
		if (percentage == 100) barChart.raiseBar(9);
		else barChart.raiseBar((int)Math.round((percentage + OFFSET) / NUMBER_OF_BARS)- 1); 
	}
	
	void nameBars() {
		for (int i = 0 ; i < NUMBER_OF_BARS ; i++) {
			int currentPercentage = (i * 100) / NUMBER_OF_BARS;
			barChart.nameBar(i, currentPercentage + "%");
		}
	}
	
	public static void main(String[] argv) {
		new Statistics().Start();
	}
}
