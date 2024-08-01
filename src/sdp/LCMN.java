package sdp;

import java.util.Scanner;

import static sdp.HCF.calculateHCF;


public class LCMN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        int lcm = arr[0];
        for (int i = 0; i < n; i++) {
            lcm = calculateLCM(lcm, arr[i]);
        }
        System.out.println(lcm);
    }
    public static int calculateLCM(int a, int b){

        int lcm = (a * b)/ calculateHCF(a, b);
        return lcm;
    }
    public static  int calculateHCF(int a, int b){
        while(a!=b)
        {
            if(a>b)
                a=a-b;
            else
                b=b-a;
        }
        return a;
    }

    public static int calculateLCMN(int[] arr){
        int lcm = arr[0];
        for (int i = 0; i < arr.length; i++) {
            lcm = calculateLCM(lcm, arr[i]);
        }
        return lcm;
    }
}
