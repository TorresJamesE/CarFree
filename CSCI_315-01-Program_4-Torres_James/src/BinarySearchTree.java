/**
 * 	BinarySearchTree.java				Author: Kathryn Sanders/Andries van Dam
 * 
 *	A second implementation of DictionaryADT.
 *
 *	Represents a Binary Search Tree.
 *	Slight modifications were made to conform with other aspects 
 *	of the program (class/variable names, extra methods).
 */
public class BinarySearchTree<T> implements DictionaryADT {
	private Node<Destination> _root; // root of this binary tree.
	private int _count;

	public BinarySearchTree(){
		// Constructor which builds an empty binary search tree.
		_root = null; // no root.
		_count = 0; // no nodes are present, this zero.
	}
	public void insert(String key, Destination value){
		// The insert method will pass its parameters to an auxillary method
		_root = this.insertAux(new Node<Destination>(value), _root);
		_count++;
	}
	
	private Node<Destination> insertAux(Node<Destination> nodeToAdd, 
									   Node<Destination> currNode){
		if(_root == null) {
			return nodeToAdd;
		} else {
			String currKey = currNode.getElement().getName();
			String keyToAdd = nodeToAdd.getElement().getName();
			int compare = keyToAdd.compareTo(currKey);
			if (compare < 0) { // new key is less, go left
				Node<Destination> leftChild = currNode.getLeftChild();
				if (leftChild == null){
					nodeToAdd.setParent(currNode);
					currNode.setLeftChild(nodeToAdd);
				}
				else{
					this.insertAux(nodeToAdd, leftChild);
				}
			}
			else if(compare > 0){// new key greater, go right
				Node<Destination> rightChild = currNode.getRightChild();
				if(rightChild == null){
					nodeToAdd.setParent(currNode);
					currNode.setRightChild(nodeToAdd);
				}
				else{
					this.insertAux(nodeToAdd, rightChild);
				}
			}
			return _root;
		}
	}

	public boolean delete(String key) {
		// The delete method will call on the deleteAux method, taking
		// the specified key as a parameter and checking the tree
		// starting from the root.
		_root = this.deleteAux(key, _root); // pass in the key to be checked and the root of the tree.
		_count--;
		return true;
	}

	private Node<Destination> deleteAux(String key, 
									    Node<Destination> currNode){
		// The deleteAux method will traverse the tree until it finds a match,
		// and returns a new tree.
		if(currNode == null){ 
			return null; // Nothing to delete.
		}
		else{
			String currKey = currNode.getElement().getName();
			int compare = key.compareTo(currKey);
			
			if (compare > 0) { // go right
				currNode.setRightChild(deleteAux(key, currNode.getRightChild()));
				return currNode;
			}
			else if (compare < 0){ // go left
				currNode.setLeftChild(deleteAux(key, currNode.getLeftChild()));
				return currNode;
			}
			else { // key found. 
				Node<Destination> left  = currNode.getLeftChild();
				Node<Destination> right = currNode.getRightChild();
				if (left == null){
					return right;
				}
				else if (right == null){
					return left;
				}
				else // node being deleted has two non-null children
					return this.insertAux(right,  left);
			}
		}
	}

	public Destination find(String key) {
		Node<Destination> nodeFound = this.findAux(key, _root);
		if(nodeFound == null){
			return null; // If the node wasn't found, null is returned.
		}
		else{
			return nodeFound.getElement(); // Returns this node's element.
		}
	}
	
	private Node<Destination> findAux(String key, Node<Destination> currNode){
		// This method will traverse the
		if (currNode == null){
			return currNode;
		}
		else{
			String currKey = currNode.getElement().getName();
			int compare = key.compareTo(currKey);
			if(compare < 0){ // go left
				return this.findAux(key, currNode.getLeftChild());
			}
			else if (compare > 0){ // go right
				return this.findAux(key, currNode.getRightChild());
			}
			else {// found it
				return currNode;
			}
		}	
	}

	public boolean isEmpty(){
		// Determines if the binary search tree is empty.
		// If root is null, the tree is empty. Otherwise, it has nodes.
		if (_root == null){
			 return true;
		}
		else return false; 
	}

	public int size(){
		// Returns the size of the account.
		return _count;
	}
	
	public Node<Destination> getRoot(){
		// Returns the root of the database.
		return _root;
	}
	

	public String getContent(Node<Destination> currNode){
		// This method will traverse the tree, finding each node starting
		// from the root. It will take each element from the nodes
		// and return a concatenated string of each element's destination info.
		String contents = "";

		if(currNode.getLeftChild() != null){
			contents += getContent(currNode.getLeftChild());
	    }
	    
	    if(currNode.getRightChild() != null){
	    	contents += getContent(currNode.getRightChild());
	    }
	    
	    return currNode.getElement().toString() + contents;
	} 
}