package Sorting;

public class MergeSort {

    public void mergeSort(int arr[], int low, int high){
        int n = arr.length;
        if(low< high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    void merge(int arr[], int low, int mid, int high){
        int n1 = mid - low +1;
        int n2 = high - mid;

        int left[] = new int[n1];
        int right[] = new int[n2];
        for(int i=0; i<n1; i++){
            left[i] = arr[low + i];
        }
        for(int i=0; i<n2; i++){
            right[i] = arr[mid + 1 + i];
        }
        int i=0, j=0, k=low;
        while(i<n1 && j<n2){
            if(left[i] <= right[j]){
                arr[k] = left[i];
                i++;
            }else{
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            arr[k] = left[i];
            i++;
            k++;
        }

        while(j<n2){
            arr[k] = right[j];
            j++;
            k++;
        }
    }


    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr, 0, n-1);
        System.out.print("Sorted array : ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
