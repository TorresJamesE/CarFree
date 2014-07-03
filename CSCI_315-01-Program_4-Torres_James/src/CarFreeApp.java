//************************************************************
// CarFreeApp.java      Author: James E. Torres
//
// CarFreeApp is the main class for the Car-Free Application. 
// This class queries & responds to requests from the user. 
// The user can: add information to the database; 
// search for information; delete information; display the contents of the dabatase;
// choose a version (data structure); quit the program.
//************************************************************

import java.util.Scanner;

public class CarFreeApp {
	Destination aDestination;
	Scanner _kbd; // Used to take in the user's keyboard input.
	CarFreeDB _database; // Represents the database where destinations are stored.
	
	public CarFreeApp(){
		// Constructor method to initialize variables.
		_kbd = new Scanner(System.in);
		_database = new CarFreeDB();
	}
	
	public void startApp(){
		// Prints out an introductory message to the user.
		System.out.println("SYSTEM: Welcome to Car-Free Rhode Island!");
		this.getVersion();
	}
	
	public void getVersion(){
		// This method gets the user's version of choice or quits the program.
		// If an incorrect entry is detected, the user will repeatedly be asked 
		// until a recognized command is entered.
		System.out.println("SYSTEM: Please enter:");
		System.out.println("	1 to test the HashMap version of the program.");
		System.out.println("	2 to test the Binary tree version of the program.");
		System.out.println("	q to end the program.");
		System.out.print("USER: ");
		
		switch(_kbd.next()){
		case "1":
			_database.CarFreeDBAUX(1);
			System.out.println("SYSTEM: You have chosen the HASHMAP version.");
			this.getAppCmd();
			break;
		case "2":
			_database.CarFreeDBAUX(2);
			System.out.println("SYSTEM: You have chosen the BINARY TREE version.");
			this.getAppCmd();
			break;
		case "q":
			this.quitMessage();
			System.exit(0);
		default:
			System.out.println("SYSTEM: Incorrect command entered. Please try again.");
			this.getVersion();		
		}
	}
	
	public void getAppCmd(){
		// This method gets the user's next command of choice in terms of
		// what they want to do with the system's internal database.
		// Any unknown command will cause the system to print a message
		// and have the user try again.
		
		System.out.println("SYSTEM: What would you like to do now?");
		System.out.println("	1 to add data.");
		System.out.println("	2 to remove data.");
		System.out.println("	3 to find data.");
		System.out.println("	4 to show content of the database.");
		System.out.println(" 	c to change version.");
		System.out.println("	q to end the program.");
		System.out.print("USER: ");
		
		switch(_kbd.next()){
		case "1":
			this.addDestination();
			break;
		case "2":
			this.deleteDestination();
			break;
		case "3":
			this.findDestination();
			break;
		case "4":
			this.showContents();
			break;
		case "c":
			this.getVersion();
			break;
		case "q":
			this.quitMessage();
			System.exit(0);
		default:
			System.out.println("SYSTEM: Incorrect command entered. Please try again.");
			this.getAppCmd();
		}
	}
	
	public void addDestination(){
		// This method will handle adding a new destination into the dabatase.
		// It will call on methods in the AddPrompt class to ask the user for
		// information about the destination they wish to add, then talk to the
		// database to insert the new destination into the currently selected
		// version.
		Destination aDestination;
		String name, directions, info;
		AddPrompt request = new AddPrompt();
		
		name = request.nameOfDestination(); // Request from the user a name.
		while(_database.find(name) != null){
			System.out.println("SYSTEM: There's already a destination in the database named '" + name + "'. Please try again.");
			name = request.nameOfDestination(); // Request from the user a name.
		}
		directions = request.directionsToDestination(); // Request from the user directions.
		info = request.optionalInfo(); // Request from the user for more information

		aDestination = new Destination(name, directions, info); // create new destination.
		
		
		// insert the newly created destination into the database.
		
		_database.insert(aDestination.getName(), aDestination);
		System.out.println("SYSTEM: Destination added successfully to the database!");
		this.getAppCmd();
	}
	
	public void deleteDestination(){
		// this method will first check to see if the database is empty, and if so, it will
		// alert user. Otherwise, it will ask the user for a destination to delete.
		DeletePrompt request = new DeletePrompt();
		String key;
		
		if(_database.isEmpty()){
			System.out.println("SYSTEM: The database is currently empty, thus nothing to remove.");
		}
		else{
			key = request.destinationToDelete();
		
			if(_database.delete(key) == !true){
				System.out.println("SYSTEM: " + key + " is not in the database.");
			}
			else{
			System.out.println("SYSTEM: " + key + " has been successfully deleted.");
				if(_database.isEmpty()){
					System.out.println("SYSTEM: The dabatase is now empty.");
				}
			}
		}
		this.getAppCmd();
	}
	
	public void findDestination(){
		// This method will handle finding a destination the user specifies.
		// It will use a subclass that will prompt the user with entering
		// the name of the destination to look up in the database.
		FindPrompt request = new FindPrompt();
		String key;
		
		if(_database.isEmpty()){ // If the databse is empty, the user will be notified.
			System.out.println("SYSTEM: The database is currently empty. Please add destinations.");
		}
		else{
			key = request.destinationToFind();
			aDestination = _database.find(key);
		
			if(aDestination == null){
				System.out.println("SYSTEM: " + key + " does not exist in the dabatase.");
			}
			else{
				System.out.println("SYSTEM: " + key + " was found in the database!");
				System.out.println("SYSTEM: Now displaying contents on '" + key + "'.\n");
				System.out.println(aDestination.toString());
			}
		}
		this.getAppCmd();
	}
	
	public void showContents(){
		// This method will make the database to show its contents.
		// A message will print notifying the user if the database is empty.
		if(_database.isEmpty()){
			System.out.println("SYSTEM: The database is empty. Please add destinations.");
		}
		else{
				System.out.println("SYSTEM: Currently, the database has the following destinations: \n" + _database.toString());
			}
		this.getAppCmd();
	}
	
	public void quitMessage(){
		// This method is used to print a proper send-off message any time the user
		// decides to quit the program (rather than type it for every portion where user can quit).
		System.out.println("SYSTEM: Thank you for choosing Car-Free Rhode Island!");
	}	
}