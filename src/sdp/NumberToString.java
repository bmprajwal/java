package sdp;

import java.util.Scanner;

public class NumberToString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        int temp = n, count = 0;
        while(temp > 0){
            temp = temp / 10;
            count++;
        }
        char[] str = new char[count + 1];
        int i = count - 1;
        while (n > 0){
            int r = n % 10;
        }
    }
}
