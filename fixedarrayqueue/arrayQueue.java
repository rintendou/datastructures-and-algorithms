package fixedarrayqueue;

public class arrayQueue {
    private int[] array;
    private int front;
    private int rear;
    private int size;

    public arrayQueue(int size) {
        front = 0; // index of front.
        rear = 0; // index of rear.
        array = new int[size];
    }

    public boolean isEmpty() {
        return size == 0; // if the size is zero, then there are no elements in the array.
    }

    public boolean isFull() {
        return size == rear; // if the rear is the same as the size, that means we have reached max capacity.
    }

    public void enqueue(int num) {
        if (isFull()) {
            throw new IllegalArgumentException("Queue is full.");
        }

        array[rear] = num; // set rear pointer equal to num.
        rear++; // increment rear, so we can enqueue again.
    }

    public void dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }

        for (int i = 0; i < (rear - 1); i++) { // assuring we don't move past the rear pointer.
            array[i] = array[i + 1]; // moving all elements to the left by 1.
        }

        rear--; // decrement rear.
    }
}
