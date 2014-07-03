//************************************************************
//  AddPrompt.java     Author: James E. Torres
//
//  The purpose of this class is to print statements in regards to
//  to when a user wishes to ADD a destination to the database.
//************************************************************
public class AddPrompt extends CarFreeApp{
	
	public AddPrompt(){
	// Constructor
	}
	
	public String nameOfDestination(){
		// Asks the user for a name of the destination they wish to add.
		String name;
		
		System.out.println("SYSTEM: Please enter a name for the destination you wish to add.");
		System.out.print("USER: ");
		
		name = _kbd.nextLine(); // Record next input as name.
		
		return name;
	}
	
	public String directionsToDestination(){
		// Next, ask the user for directions to the destination.
		String directions;

		System.out.println("SYSTEM: Please enter the directions to the destination, including route/bus numbers.");
		System.out.print("USER: ");
		
		directions = _kbd.nextLine(); // Record next input as directions.
		
		return directions;
	}
	
	public String optionalInfo(){
		// Next, ask the user to add a description to the destination.
		String info;
		
		System.out.println("SYSTEM: Please enter additional information pertaining to the destination.");
		System.out.print("USER: ");
		
		info  = _kbd.nextLine();
		
		return info; // Record next input as optional info.
	}
}
