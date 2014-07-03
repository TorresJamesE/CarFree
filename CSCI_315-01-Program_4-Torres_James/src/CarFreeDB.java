//************************************************************
// CarFreeDB.java      Author: James E. Torres
//
// CarFreeDB implements DictionaryADT & is an adapter representation of a database that will store
// the destination objects in a back-end data structure
//************************************************************

import java.util.HashMap;
import java.util.Iterator;

public class CarFreeDB implements DictionaryADT {
	private int versionNum; // holds the value of the current version being used.
	private HashMap<String, Destination> _hm; // variable represents a hashmap.
	private BinarySearchTree<Node<Destination>> _bt; // variable represents a binary tree.
	
	public CarFreeDB(){
		// The constructor method will initialize both data structures
		// but will strictly use the user-specified version by 
		// checking the versionNum throughout carFreeDB's method calls.
		_hm = new HashMap<String, Destination>();
		_bt = new BinarySearchTree<Node<Destination>>();
	}
	
	public void CarFreeDBAUX(int num){
		// An auxillary method that takes an integer as a parameter which is then
		// a flag that determines what version to use (1 = Hashmap, any # other than 1 would default to
		// a linked binary tree).
		versionNum = num;
	}
	
	public void insert(String key, Destination value){
		// The insert method will store the destination into the database.
		if(versionNum == 1){
			_hm.put(key, value); // uses built-in java hashmap method to insert the key and value.
		}
		else{
			_bt.insert(key, value); // calls binary tree classes insert method to insert key and value.
		}
	}
	
	public boolean delete(String key) {
		// The delete method will first check to see which version
		// of the database is currently in use. Each database version will look search
		// for the specified key. If the key is found, then it will be deleted
		// and return true to notify the user that it has been deleted.
		// If the key was not found false is returned. 
		boolean bool = false;
		
		if(versionNum == 1){ // Hashmap version of the database.
			if(_hm.containsKey(key)){ // Checks the hashmap for the key.
				bool = true;
				_hm.remove(key); // Deletes the destination from the hashmap.	
			}
		}
		else{
			if(_bt.find(key) != null){
				_bt.delete(key);
				bool = true;
			}
		}
		return bool;
	}

	public Destination find(String key) {
		// This method will search the database for an entry that matches the specified key.
		// If found, it will return the destination. Otherwise, null is returned which
		// means the database does not have it.
		Destination rDestination = null; // 
		
		// Hashmap version.
		if(versionNum == 1){ 
			if(_hm.containsKey(key)){
				rDestination = _hm.get(key);
			}
		}
		// Binary Search Tree version.
		else{
			rDestination = _bt.find(key);
		}
		return rDestination;
	}

	public boolean isEmpty(){
		// This method will check to see if the database is empty for the particular
		// version the user is using and return true if it is.
		boolean bool = false;
		
		if(versionNum == 1){ // Check hashmap to see if empty.
			if (_hm.isEmpty()){
				bool = true;
			}
		}
		else{
			if(_bt.isEmpty()){ // Check binary search tree to see if empty.
				bool = true;
			}
		}
		return bool;
	}

	public int size() {
		// This method will return the current size of the database.
		int dbSize = 0; // Refers to the size of the underlying data structure that was chosen.
		
		if(versionNum == 1){ // Hashmap version.
			dbSize = _hm.size();
		}
		else{
			dbSize = _bt.size(); // Binary search tree version.
		}
		return dbSize;
	}
	
	public String toString(){
		// This method is used to display the contents of the database.
		// An iterator is used to go through all the keys stored in the database,
		// then print each destination's information, separated by a line.
		String key, contents = "\n";
		Destination aDestination;
		Iterator<String> iterator;
		
		if(versionNum == 1){
			iterator = _hm.keySet().iterator();
			while (iterator.hasNext()){  
				key = iterator.next();
				aDestination = _hm.get(key);

				contents = contents + aDestination.toString();
			}
		}
		else{
			contents = _bt.getContent(_bt.getRoot());
		}
	    return contents;
	}
}