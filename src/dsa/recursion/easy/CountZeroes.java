package dsa.recursion.easy;

public class CountZeroes {
    public static void main(String[] args) {
        long n = 304020;
        System.out.println(count(n));
    }

    static int count(long n){
        return helper(n, 0);
    }
    static int helper(long n, int c){
        if(n == 0){
            return c;
        }
        long rem = n % 10;
        if(rem == 0){
            return helper(n/10, c+1);
        }
        return helper(n/10, c);
    }
}
