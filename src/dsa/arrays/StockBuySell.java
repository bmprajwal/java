package dsa.arrays;

public class StockBuySell {
    public static void main(String[] args) {
        int[] arr = {3,2,6,10,9,15,18};
        System.out.println(maxProfit(arr));
    }
    static int maxProfit(int[] arr){
        int profit = 0;
        for(int i = 1; i < arr.length;i++){
            if(arr[i] > arr[i-1]){
                profit += arr[i] - arr[i-1];
            }
        }
        return profit;
    }
}
