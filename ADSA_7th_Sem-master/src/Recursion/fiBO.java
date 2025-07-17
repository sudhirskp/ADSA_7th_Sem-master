package Recursion;

public class fiBO {

    public int fibo(int n) {
            if(n == 0 || n == 1) return n;
            return fibo(n-1) + fibo(n-2);
    }
    public static void main(String[] args) {
        fiBO f = new fiBO();
        int n = 48;
        int i=0;
        System.out.print("Fibonacci number at position " + n + " is: ");
        while(i<=n) {
            System.out.print(f.fibo(i) + " ");
            i++;
        }
    }
}