//************************************************************
// FindPrompt.java      Author: James E. Torres
//
//  The purpose of this class is to print statements in regards to
//  to when a user wants to Find a destination in the database.  
//************************************************************

public class FindPrompt extends CarFreeApp {
	public FindPrompt(){
	}
	public String destinationToFind(){
		String aKey;
		
		System.out.println("SYSTEM: Okay. Please enter the name of the destination you wish to find.");
		System.out.print("USER: ");
		aKey = _kbd.nextLine();
		
		return aKey;
	}
}

