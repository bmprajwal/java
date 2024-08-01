package leetCode;

public class PerfectSquare {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(14));
    }
    public static boolean isPerfectSquare(int num) {
        int start = 1;
        int end = num;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if((long) mid * mid > (long) num){
                end = mid - 1;
            } else if(mid * mid < num){
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
