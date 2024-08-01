package dsa.recursion;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fiboFormula(10));
    }

    static int fibo(int n){
        if(n < 2){
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }

    static long fiboFormula(int n){
        return (long) (((Math.pow((1 + Math.sqrt(5)) / 2 , n)) - (Math.pow((1 - Math.sqrt(5)) / 2 , n))) / Math.sqrt(5));
    }
}
