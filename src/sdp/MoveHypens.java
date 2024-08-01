package sdp;

import java.util.Arrays;
import java.util.Scanner;

public class MoveHypens {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.next();

        String[] arr = str.split("-");

        String[] result = new String[arr.length + arr.length-1];

        StringBuilder finalStr = new StringBuilder();

        int i ;
        for ( i = 0; i < arr.length - 1; i++) {
            result[i] = "-";
            finalStr.append(result[i]);
        }
        for (int j = 0; j < arr.length; j++) {
            result[i] = arr[j];
            finalStr.append(result[i]);
            i++;
        }

        System.out.println(finalStr);
    }
}
