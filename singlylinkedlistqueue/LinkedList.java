package singlylinkedlistqueue;

public class LinkedList {
    private Node front;
    private Node rear;
    private int size;

    public LinkedList() {
        front = null;
        rear = null;
        size = 0;
    }
    
    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(Object data) {
        Node newNode = new Node(data);

        if (rear == null) {
            rear = newNode;
        }

        Node oldRear = rear;
        oldRear.setNext(newNode);
        rear = newNode;
        size++;
    }

    public void dequeue() {
        if (front == null) {
            rear = null;
        }

        front = front.getNext();
        size--;
    }
}
