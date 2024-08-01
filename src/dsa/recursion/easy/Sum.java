package dsa.recursion.easy;

public class Sum {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(sum(n));
    }

    static int sum(int n){
        if(n == 1){
            return 1;
        }
        return n + sum(n - 1);
    }
}
