package sdp;

import java.util.Scanner;

import static sdp.LCMN.calculateLCM;

public class LCMK {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = input.nextInt();

        System.out.print("Enter the value of k: ");
        int k = input.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter the array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        int maxLCM = 0;
        int index = 1;
        for (int i = 1; i <= k; i++) {
            int lcm = calculateLCMN(arr, i);
            if (lcm > maxLCM) {
                maxLCM = lcm;
                index = i;
            }
        }

        System.out.println(index);
    }
    public static int calculateLCMN(int[] arr, int k){
        int n = arr.length;
        int[] newarr = new int[n + 1];
        for (int i = 0; i < n; i++)
          newarr[i] = arr[i];

        newarr[n] = k;
        int lcm = newarr[0];
        for (int i = 0; i < newarr.length; i++) {
            lcm = calculateLCM(lcm, newarr[i]);
        }
        return lcm;
    }
}
