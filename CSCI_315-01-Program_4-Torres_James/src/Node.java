//*******************************************************************
//  Node.Java								Authors: Kathryn Sanders/Andries van Dam
//
//  Represents a node in a binary search tree with a left and right child.
//  Slight modifications made to mesh well with other parts of the source code (i.e. variable/method names)
//*******************************************************************

public class Node<T>{
   private T element;
   private Node<T> parent, left, right;

   /*****************************************************************
     Creates a new tree node with the specified data.
   *****************************************************************/
   public Node(T object) {
      element = object;
      left = null;
      right = null;
      parent = null;
   }
   
   public T getElement(){
	   return element;
   }
   
   public Node<T> getParent(){
	   return parent;
   }
   
   public Node<T> getLeftChild(){
	   return left;
   }
   
   public Node<T> getRightChild(){
	   return right;
   }
   
   public void setParent(Node<T> aNode){
	   parent = aNode;
   }
   public void setLeftChild(Node<T> aNode){
	   left = aNode;
   }
   
   public void setRightChild(Node<T> aNode){
	   right = aNode;
   }

   /*****************************************************************
     Returns the number of non-null children of this node.
    *****************************************************************/
   public int numChildren() {
      int children = 0;

      if (left != null)
         children = 1 + left.numChildren();

      if (right != null)
         children = children + 1 + right.numChildren();

      return children;
   }
}

