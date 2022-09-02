package sorting.quicksort;

import java.util.Random;

public class QuickSort {
    public void quicksort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int low, int high) { // Parameters: arr | lowest index | highest index
        if (low >= high) return;

        int random = new Random().nextInt(high - low) + low;
        int pivot = arr[random];
        swap(arr, pivot, high);

        int left = partition(arr, low, high, pivot);

        quickSort(arr, low, left - 1);
        quickSort(arr, left + 1, high);
    }

    public void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public int partition(int[] arr, int low, int high, int pivot) { 
        int left = low;
        int right = high - 1;

        while (left < right) {
            while (arr[left] <= pivot && left < right) left++;
            while (arr[right] >= pivot && left < right) right--;
            swap(arr, left, right);
        }

        swap(arr, left, pivot);
        return left;
    }
}
