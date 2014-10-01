package Pizza;

import java.io.PrintStream;

public class Pizza {
	//Name       : Rink Stiekema
	//Assignment : Pizza
	//Data       : 10-09-2014
	PrintStream out;
	
	static final int TOTALINGREDIENTSMARIO = 10,
	                 INGREDIENTSONPIZZAMARIO = 3, 
					 TOTALINGREDIENTSLUIGI = 9,
					 INGREDIENTSONPIZZALUIGI = 4; 
	
	Pizza(){	
		out = new PrintStream(System.out);
	}
	
	int factorial(int numberFactorial){
		int result = 1;
		for(int i = 1; i <= numberFactorial; i++){
			result *= i;
		}
		return result; 
	}
	
	int calculatePossibilities(int totalIngredients, int ingredientsOnPizza){
		return factorial(totalIngredients) / factorial(ingredientsOnPizza) * (factorial(totalIngredients - ingredientsOnPizza));
	}
	
	
	void printWinner(int possibilitiesMario, int possibilitiesLuigi){
		if(possibilitiesMario > possibilitiesLuigi){
			out.printf("Mario won the bet");
		}else{
			out.printf("Luigi won the bet");
		}
	}
	
	public void start(){
		int possibilitiesMario = calculatePossibilities(TOTALINGREDIENTSMARIO, INGREDIENTSONPIZZAMARIO);
		int possibilitiesLuigi = calculatePossibilities(TOTALINGREDIENTSLUIGI, INGREDIENTSONPIZZALUIGI);
		
		printWinner(possibilitiesMario, possibilitiesLuigi);		
	}
	
	
	public static void main(String[] args) {
		new Pizza().start(); 
	}
}