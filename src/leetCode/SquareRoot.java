package leetCode;

public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(sqrt(8));
    }

    public static int sqrt(int x){
        if(x == 0 || x == 1){
            return x;
        }
        int start = 1;
        int end = x;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if((long)mid*mid > (long)x){
                end = mid - 1;
            } else if((mid * mid) < x){
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return Math.round(end);
    }
}
