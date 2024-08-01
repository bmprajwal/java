package leetCode;

public class IdenticalTwins {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 2, 1};
        System.out.println(getIdenticalTwinsCount(arr));
    }
    static int getIdenticalTwinsCount(int[] arr){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] == arr[j]){
                    count++;
                }
            }
        }
        return count;
    }
}
