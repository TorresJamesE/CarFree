//************************************************************
//  Destination.java     Author: James E. Torres
//
//  This class represents an object in the form of a destination
//  that can be reached on RIPTA. Each Destination should have a name,
//  directions on how to get there on the bus (with route numbers),
//  optional additional information, and a means of retrieving a
//  specific destination object.
//************************************************************
public class Destination {
	String _name, _directions, _moreinfo;
	
	public Destination(String name, String directions, String info){
		_name = name;
		_directions = directions;
		_moreinfo = info;
	}
	
	public void setName(String aName){
		// Allows the user to set or modify the name of this destination.
		_name = aName;
	}
	
	public void setDirections(String directions){
		// Allows the user to set or modify the directions of this destination.
		_directions = directions;
	}
	
	public void setMoreInfo(String info){
		// Allows the user to set or modify the additional info of this destination.
		_moreinfo = info;
	}
	
	public String getName(){
		// Returns the name of this destination.
		return _name;
	}
	
	public String getDirections(){
		// Returns the directions stored for this destination.
		return _directions;
	}
	
	public String getMoreInfo(){
		// Returns additional information stored for this destination.
		return _moreinfo;
	}
	
	public String toString(){
		// This method will return this destination in a string representation.
		String dest, dir, inf, breakline, DestToString;

		dest = "	Destination: " + _name + "\n";
		dir  = "	Directions : " + _directions + "\n"; 
		inf  = "	Description: " + _moreinfo + "\n";
		DestToString = dest + dir + inf;
	    breakline = "=========================================== \n";
		
		return breakline + DestToString + breakline;
	}
}