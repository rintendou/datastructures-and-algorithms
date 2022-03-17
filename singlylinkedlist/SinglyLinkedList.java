package singlylinkedlist;

import java.util.NoSuchElementException;

public class SinglyLinkedList {
    // Initializing global variables that will be used throughout the program.
    private Node head;
    private int size;


   // Linked List Constructor.
   public SinglyLinkedList() {
       head = null;
   }

   // getFirst() method.
   public Object getFirst() {
       if (head == null) {
           throw new NoSuchElementException();
       }
       return head.getData();
   }

   // size() method: returns the size of the linked list.
   public int size() {
       if (head == null) {
           size = 0;
       }
       return size;
   }

   // empty() method: if head != null, then it will print out false. otherwise, true.
   public Boolean empty() {
       return head == null;
   }

   // front() method: returns the head.
   public Object front() {

       if (head == null) {
           throw new NoSuchElementException();
       }

       return head;
   }

   // back() method: returns the last node of the list, otherwise known as the tail.
   public Object back() {

       if (head == null) {
           throw new NoSuchElementException();
       }

       Node temp = head;

       while (temp.getNext() != null) {
           temp = temp.getNext();
       }

       return temp.getData();
   }

   // valueAt() method: Loops through the list until it reaches the index selected and returns the value.
   public Object valueAt(int index) {
       if (head == null) {
           throw new NoSuchElementException();
       }

       Node temp = head;
       for (int i = 0; i < index; i++) {
           temp = temp.getNext();
       }

       return temp;
   }

   // insert() method: 
   public void insert(int index, Object data) {
       Node newNode = new Node(data); // create new node.

       if (head == null) {
           head = new Node(data);
           size++;
       } else {
        Node temp = head; // set a temp variable to the head.
        for (int i = 0; temp != null && i < index - 1; i ++) { // grab the second to last node and store it into temp.
            temp = temp.getNext();
        }
        Node afterNode = temp.getNext(); // store the last node to a variable
        temp.setNext(newNode); // set "temp" reference (second to last node) to the newNode
        newNode.setNext(afterNode); // set the newNode's next to the lastNode.
        size++; 
       }
   }

   // append() method: add a node at the end of the list.
   public void append(Object node) {
       Node newNode = new Node();

       if (head == null) {
            head = new Node(node);
       }

       newNode.setNext(null); // set the new node's pointer to null.
       
       Node temp = head; // should work hopefully.
       while (temp.getNext() != null) {
           temp = temp.getNext();
       }

       temp.setNext(newNode);
       size++;
   }

   // popBack() method: remove and return the last node.
   public Object popBack() {
       if (head == null) {
           throw new NoSuchElementException();
       }

       Node temp = head; // create dupe head pointer, will be used to tracking "index".
       for (int i = 0; i < size - 1; i++) { // size keeps track of how many node there are in the list.
           temp.getNext(); // doing .next, size - 1 times.
       }

       temp.setNext(null); // overwrite the next pointer to null.
       size--; // decrease size by one.
       return temp;
   }

   // erase() method: remove a node at an given index.
   public void erase(int index) {
       if (head == null) {
           throw new NoSuchElementException();
       }

       Node temp = head;

       // 
       if (index == 0 ) {
           head = temp.getNext();
           return;
       }

       // Find the node before the one we want to delete.
       for (int i = 0; temp != null && i < index - 1; i++) {
           temp = temp.getNext();
       }

       // Created variable to hold the node after the one we want to remove.
       Node afterNode = temp.getNext();

       // Set it's next to null to unlink the the node.
       temp.setNext(afterNode);
       size--;

   }

   // Method to add a new node to the beginning of the list.
   public void addFirst(Object obj) {
       Node newNode = new Node(); // Creates a single new node.
       newNode.setData(obj); // Set the data of the new node the obj.
       newNode.setNext(head); // Set our newNode's reference to the current head.
       head = newNode; // Set the current head to our newly created node.
       size++; // increase size counter by one.
   }

   // Method to remove the first node in the list.
   public Object removeFirst() {


       if (head == null) {
           throw new NoSuchElementException();
       }

       Object obj = head.getNext();
       head = head.getNext();
       size--;
       return obj;
    }

   // reverse() method: reverses the nodes of the list. 
   public void reverse() {
       if (head == null) { // edge case
           return;
       }

       Node prev = null;
       Node current = head;
       Node next;

       while (current != null) {
           next = current.getNext();
           current.setNext(prev);
           prev = current;
           current = next;
       }
       head = current;
   }

   // removeValue() method: removes the first node that has the specified data within.
   public Object removeValue(Object val) {
       if (head == null) {
           throw new NoSuchElementException();
       }

       Node prev = null;
       Node current = head;
       Node next = null;
       
       while (current.getData() != val) {
           next = current.getNext();
           prev = current;
           current = next;
           next = next.getNext();
       }
       
       prev.setNext(next);
       size--;
       return current;
    }

   // valueNFromEnd method: returns the nth node from the last node.
   public Object valueNFromEnd(int n) { 
       if (head == null) {
           throw new NoSuchElementException();
       }

       if (size < n) {
           return -1;
       }

       Node temp = head;

       for (int i = 0; i < (size - n) + 1; i++) {
           temp = temp.getNext();
       }

       size--;
       return temp;
   }

   public static void main(String[] args) {
     
    } 
}