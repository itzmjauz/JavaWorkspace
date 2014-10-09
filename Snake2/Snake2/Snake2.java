package Snake2;

public class Snake2 {

	private int direction = 0; // direction; 0 for right, 1 for down, 2 for left, 3 for upwards. 
	
	Snake2(){
		
	}
	
	void Start(){
		//loop which checks for events and passes these to processEvent(Event event)
		// new Grid object from the Grid class, with wanted WIDTH + HEIGHT
		// calls to tick() which updates the grid
		// calls to updateUI which updates the interface 
	}
	
	void processEvent(Event event){
		// process each event, for example event.data=="R" would change the direction to 0.
		// there's also the events created by setFramesPerSecond, called 'refresh' , which should call
		// updateGrid and updateUI afterwards , 
	}
	
	void updateUI(){
		// call the ui.place methods, whilst iterating over the grid object to update the whole Interface
		// then call ui.showChanges() to actually show these Changes. 
	}
	
	public static void main(String[] argv){
		new Snake2().Start();
	}
}
