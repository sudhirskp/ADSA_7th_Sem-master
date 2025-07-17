package Practice;

import java.util.Scanner;

public class PrefixSum {

    public int [] input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of Arr : ");
        int n = sc.nextInt();
        System.out.print("Enter the array Element : ");
        int [] arr = new int [n];
        for(int i=0; i<n ; i++){
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public int [] presum(int [] arr) {
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        for (int i = 0; i < prefixSum.length; i++) {
            System.out.print(prefixSum[i] + " ");
        }
        return prefixSum;
    }

    public int RangeSum(int start , int end , int [] preSum){
        if(start == end) return preSum[end];
        return preSum[end] - preSum[start-1];
    }

    public static void main(String[] args) {
       PrefixSum ob = new PrefixSum();
       int [] arr = ob.input();
       int [] preSum = ob.presum(arr);
       System.out.println();
       System.out.println(ob.RangeSum(6, 7, preSum));
    }
}
