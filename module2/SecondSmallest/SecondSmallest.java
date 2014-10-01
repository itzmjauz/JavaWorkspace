package SecondSmallest;

import java.io.PrintStream;
import java.util.Scanner;

public class SecondSmallest {
	// Name 		: Antoni Stevenet
	// Assignment	: SecondSmallest
	// Date 		: 2014-sep09-wed10
	
	PrintStream out;
	int smallNum,smallestNum,numContainer;
	
	SecondSmallest(){
		out = new PrintStream(System.out);
	}
	
	void Start(){
		Scanner in = new Scanner(System.in);
		
		out.print("Please enter some random numbers seperated by newlines: \n");
		
		while(in.hasNext()){
			numContainer = in.nextInt();
			if(smallNum == 0 && smallestNum==0) smallNum=numContainer;
			else if(smallestNum==0){
				if(smallNum > numContainer) smallestNum=numContainer;
				else{
					smallestNum=smallNum;
					smallNum=numContainer;
				}
			}
			else if(numContainer < smallNum && numContainer > smallestNum ) smallNum = numContainer;
			else if(numContainer < smallestNum ){
				smallNum = smallestNum;
				smallestNum = numContainer;
			}
		}
		out.printf("The second to smallest number is %d !", smallNum);
		
		in.close();
	}
	
	public static void main(String[] argv){
		new SecondSmallest().Start();
	}
}
