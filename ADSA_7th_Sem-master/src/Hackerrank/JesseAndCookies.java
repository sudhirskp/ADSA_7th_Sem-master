package Hackerrank;

import java.util.PriorityQueue;

public class JesseAndCookies {

    public int cookies(int k, int[] a) {
       PriorityQueue<Integer> pq = new PriorityQueue<>();
       for(int i = 0 ; i < a.length ; i++){
           pq.add(a[i]);
       }
       int count = 0;
       while(pq.peek() < k){
           if(pq.size() == 1){
               return -1;
           }
           int first = pq.poll();
           int second = pq.poll();
           pq.add(first + 2 * second);
           count++;
       }
       return count;

    }
    public static void main(String[] args) {
        int k = 7;
        int[] a = {1,2,3,9,10,12};
        JesseAndCookies obj = new JesseAndCookies();
        System.out.println(obj.cookies(k, a));
    }
}
//https://www.hackerrank.com/challenges/jesse-and-cookies/problem?isFullScreen=true
//jesse-and-cookies