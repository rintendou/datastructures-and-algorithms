package sorting.quicksort;

import java.util.Random;

public class QuickSortTester {
    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        Random rand = new Random();
        int[] nums = new int[10];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt(100);
        }

        System.out.println("Pre-sorted Array: " + '\n');
        sort.quicksort(nums); // Error.
        printArray(nums);
        
        System.out.println("Quicksorted Array: " + '\n');
        printArray(nums);
        
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + '\n');
        }
    }
}

