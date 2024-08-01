package leetCode;

public class MinCostToMoveChips {
    public static void main(String[] args) {
        int[] positions = {1,2,3};
        System.out.println(minCostToMoveChips(positions));
    }
    public static int minCostToMoveChips(int[] position) {
        int evenCount = 0, oddCount = 0;
        for(int num: position){
            if((num & 1) == 0){
                evenCount++;
            } else {
                oddCount++;
            }
        }
        return Math.min(evenCount, oddCount);
    }
}
