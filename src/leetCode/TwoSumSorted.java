package leetCode;

public class TwoSumSorted {
    public static void main(String[] args) {

    }
    public static int[] twoSum(int[] numbers, int target){
        int start = 0;
        int end = numbers.length - 1;
        while (start < end){
            int sum = numbers[start] + numbers[end];
            if(sum > target){
                end--;
            } else if (sum < target){
                start++;
            } else {
                return new int[]{start+1, end+1};
            }
        }
        return new int[]{-1,-1};
    }
}
