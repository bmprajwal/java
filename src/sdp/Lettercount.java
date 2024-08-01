package sdp;

import java.util.Scanner;

public class Lettercount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String arr = input.next();
        char[] str = arr.toCharArray();

        int count = 1;
        char ch = str[0];
        for (int i = 1; i < str.length ; i++) {
            if (str[i] == ch){
                count++;
            } else {
                System.out.println(ch + " = " + count);
                count = 1;
                ch = str[i];
            }


        }
    }
}
