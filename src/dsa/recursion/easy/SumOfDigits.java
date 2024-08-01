package dsa.recursion.easy;

public class SumOfDigits {
    public static void main(String[] args) {
        int n = 55;
        System.out.println(prodOfDigits(n));
    }

    static int sumOfDigits(int n){
        if(n == 0){
            return 0;
        }
        return n % 10 + sumOfDigits(n / 10);
    }

    static int prodOfDigits(int n){
        if(n == 0){
            return 1;
        }
        return n % 10 * prodOfDigits(n / 10);
    }
}
