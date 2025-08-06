package Sorting;

public class CountingSort {

    int [] countSort(int [] arr){
        int n = arr.length;
        int max =-1;
        for(int val : arr){
            max = Math.max(max,val);
        }

        int [] count = new int[max+1];

        for(int i =0;i<n;i++){
            count[arr[i]]++;
        }

        for(int i=1;i<=max;i++){
            count[i] = count[i] + count[i-1];
        }

        int [] temp = new int [arr.length];
        for(int i = arr.length-1;i>=0;i--){
            int index = --count[arr[i]];
            temp[index] = arr[i];
        }
        return temp;
    }
    public static void main(String[] args) {
        CountingSort ob = new CountingSort();
        int [] arr = {2,4,5,6,4,6};
        int [] a = ob.countSort(arr);

        for(int val : a) {
            System.out.print(val + " ");
        }
    }
}
