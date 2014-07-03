//************************************************************
// DeletePrompt.java      Author: James E. Torres
//
//  The purpose of this class is to print statements in regards to
//  to when a user wants to DELETE a destination in the database.  
//************************************************************

public class DeletePrompt extends CarFreeApp {
	public DeletePrompt(){}
	public String destinationToDelete(){
		String aKey;
		
		System.out.println("SYSTEM: Okay. Please enter the destination you wish to delete.");
		System.out.print("USER: ");
		aKey = _kbd.nextLine();
		
		return aKey;
	}
}
