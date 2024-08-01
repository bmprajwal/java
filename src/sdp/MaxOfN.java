package sdp;

import java.util.Scanner;

public class MaxOfN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many numbers? ");
        int n = input.nextInt();

        int[] arr = new int[n];
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.nextInt();
            if (arr[i] > max1){
                max2 = max1;
                max1 = arr[i];
            } else if (arr[i] > max2 && arr[i] < max1) {
                max2 = arr[i];
            }
        }
        System.out.println(max2);
    }
}
