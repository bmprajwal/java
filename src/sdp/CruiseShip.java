package sdp;

import java.util.Scanner;

public class CruiseShip {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = 5;
        int[] e = {1,4,3,2,1};
        int[] l = {0,1,2,3,};

        int current = 0;
        int max = 0;

        for (int i = 0; i < e.length; i++) {
            current = current + (e[i]- l[i]);
            if (current > max)
                    max = current;
        }
        System.out.println(max);
    }
}
