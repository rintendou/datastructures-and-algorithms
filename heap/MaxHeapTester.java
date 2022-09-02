package heap;

public class MaxHeapTester {
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(2);
        heap.insert(5);
        heap.insert(20);
        heap.insert(30);
        heap.insert(60);
        heap.insert(2);
        heap.printHeap();
    }
}
