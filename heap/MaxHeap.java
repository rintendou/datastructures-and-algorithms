package heap;


public class MaxHeap {
    int[] heap; 
    int items;
    int maxSize;

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.items = 0;
        heap = new int[maxSize];
    }

    // Helper methods that will allow for easier manipulation of the Heap.
    public int[] resize() {
        int[] temp = new int[maxSize * 2];
        for (int i = 0; i < maxSize; i++){
            temp[i] = heap[i];
        }
        maxSize*=2;
        return temp;
    }

    public void swap(int parent, int child) {
        int temp = heap[child];
        heap[child] = heap[parent];
        heap[parent] = temp;
    }

    public int parent(int index) {return index / 2;}
    public int left(int index) {return ((index - 1) / 2) + 1;}
    public int right (int index) {return ((index - 1) / 2) + 2;}

    public void printHeap() {
        for (int i = 0; i < items; i++) {
            System.out.println(heap[i]);
        }
    }

    // Beginning of Heap methods.
    public void insert(int num) {
        if (items == maxSize) heap = resize(); // If the heap is full, resize the heap to double the size.
        items++;
        heap[maxSize - 1] = num;
        siftUp(maxSize - 1);
    }

    public int extractMax() {
        int max = heap[0];
        heap[0] = heap[maxSize - 1];
        siftDown(0);
        items--;
        return max;
    }

    public void maxHeapify(int index) {
        int largestIndex = index; // Initialize as the root (aka index 0)
        int left = left(index); 
        int right = right(index);

        // Checking to make sure we are still in range and whether there are any children that violate the heap properties.
        if (left < maxSize && heap[left] > heap[largestIndex]) largestIndex = left; 
        if (right < maxSize && heap[right] > heap[largestIndex]) largestIndex = right;
        if (largestIndex != index) { 
            swap(heap[index], heap[largestIndex]);
            maxHeapify(largestIndex); 
            // Recursive call that will heapify the heap starting from top down. The stack will begin clearing once we have reached the leaves as all the if-conditions will fail.
        }
    }

    public void heapSort() {

    }

    public void siftUp(int current) {
        // Starts at the leaf and begin swapping up until heap order has been fixed.
        while (current > 0 && heap[parent(current)] < heap[current]) {
            swap(parent(current), current);
            current = parent(current);
        }
    } 

    public void siftDown(int current) {
        int root = heap[current];
        int left = heap[left(current)];
        int right = heap[right(current)];

        if (left > root && right > root) { // If both left and right children are both larger than the new root, compare which of the two is the largest and use that for the swap.
            if (left > right) {
                swap(root, left);
                root = left(current);
            } else {
                swap(root, right);
                root = right(current);
            }
        }

        if (left > root) { // If the left root is larger...
            swap(root, left);
            root = left(current);
        } else { // Otherwise right root is larger...
            swap(root, right);
            root = right(current);
        }
        siftDown(root);
    }

    public int getMax() {
        return heap[0]; // First element in a MaxHeap is the largest.
    }

    public int getSize() {
        return items;
    }
    
    public boolean isEmpty() {
        return items == 0;
    }
}
