package Sorting;

public class RedixSort {

    // Function to get maximum element from array
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }

    // Main function to implement radix sort
    public static void radixSort(int[] arr) {
        // Get maximum element
        int max = getMax(arr);
        int place = 1;
        // Apply counting sort for every place value
        while (max / place > 0) {
            countSort(arr, place);
            place *= 10;
        }
    }

    // Function to do counting sort based on place value
    public static void countSort(int[] arr, int place) {
        int[] count = new int[10];
        for (int val : arr) {
            count[(val / place) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        int[] output = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[(arr[i] / place) % 10] - 1] = arr[i];
            count[(arr[i] / place) % 10]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 567, 999, 689, 22, 66};
        System.out.print("Original array : ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        radixSort(arr);
        System.out.print("Sorted array : ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
