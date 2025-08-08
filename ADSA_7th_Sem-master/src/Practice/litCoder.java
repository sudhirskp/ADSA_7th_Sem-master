package Practice;

import java.util.*;

public class litCoder {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        // Read all integers into a list until -1 is entered
//        List<Integer> nums = new ArrayList<>();
//        System.out.println("Enter integers (enter -1 to stop):");
//        while (true) {
//            int num = sc.nextInt();
//            if (num == -1) break;
//            nums.add(num);
//        }
//
//        // Find max value in input
//        int maxVal = 0;
//        for (int num : nums) {
//            if (num > maxVal) maxVal = num;
//        }
//
//        // Create frequency array
//        int[] freq = new int[maxVal + 1];
//        for (int num : nums) {
//            freq[num]++;
//        }
//
//        // Print frequencies from max down to 0
//        for (int i = maxVal; i >= 0; i--) {
//            System.out.print(freq[i] + " ");
//        }

        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        String [] pr = str.trim().split("\\s+");
        int [] arr = new int[pr.length];

        int MaxVal =0;
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(pr[i]);
            MaxVal = Math.max(MaxVal,arr[i]);
        }
        // for(int val : list){
        //     //MaxVal = Math.max(MaxVal,val);
        //     if(val > MaxVal){
        //         MaxVal = val;
        //     }
        // }

        int [] count = new int[MaxVal+1];
        for(int v : arr){
            count[v]++;
        }

        for(int i=MaxVal;i>=0;i--){
            System.out.print(count[i]+" ");
        }
    }
//   ------------------------------------------------------------------------
//            public static void main(String[] args) {
//                Scanner sc = new Scanner(System.in);
//
//                // Read the entire line as a string
//                String line = sc.nextLine();
//                String[] parts = line.trim().split("\\s+");
//
//                int n = parts.length; // number of elements
//                int[] arr = new int[n];
//
//                // Fill the array
//                for (int i = 0; i < n; i++) {
//                    arr[i] = Integer.parseInt(parts[i]);
//                }
//
//                // Find max value
//                int maxVal = 0;
//                for (int num : arr) {
//                    if (num > maxVal) maxVal = num;
//                }
//
//                // Count frequency
//                int[] freq = new int[maxVal + 1];
//                for (int num : arr) {
//                    freq[num]++;
//                }
//
//                // Output from max to 0
//                for (int i = maxVal; i >= 0; i--) {
//                    System.out.print(freq[i] + " ");
//                }
//            }

}