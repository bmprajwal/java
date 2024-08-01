package leetCode;

public class CountSteps {
    public static void main(String[] args) {
        int n = 41;
        System.out.println(numberOfSteps(n));
    }
    static int numberOfSteps(int num) {
        return helper(num, 0);
    }

    static int helper(int num, int c){
        if(num == 0){
            return c;
        }
        if(num % 2 == 0){
            return helper(num/2, c+1);
        }
        return helper(num - 1, c+1);
    }
}
