package leetCode;

public class ArrangingCoins {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(6));
    }
    public static int arrangeCoins(int n) {
        int start = 1;
        int end = n;
        while(start <= end){
            int mid = start + (end - start) / 2;
            int coinsUsed = mid * (mid + 1) / 2;
            if(coinsUsed > n){
                end = mid - 1;
            } else if (coinsUsed < n){
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return end;
    }
}
