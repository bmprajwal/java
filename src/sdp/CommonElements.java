package sdp;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        
        int[] arr1 = new int[a];
        int[] arr2 = new int[b];

        for (int i = 0; i < a; i++) {
            arr1[i] = input.nextInt();
        }
        
        for (int i = 0; i < b; i++) {
            arr2[i] = input.nextInt();
        }

        for (int i = 0; i < arr1.length; i++) {
            boolean unique = true;
            for (int j = 0; j < arr2.length; j++) {
                if(arr1[i] == arr2[j])
                    unique = false;
            }
            if (unique) System.out.println(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            boolean unique = true;
            for (int j = 0; j < arr1.length; j++) {
                if(arr2[i] == arr1[j])
                    unique = false;
            }
            if (unique) System.out.println(arr2[i]);
        }
    }
}
