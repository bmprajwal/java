package sdp;

import java.util.Scanner;

public class EvenOddNoMod {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        if((a & 1) == a)
            System.out.println("Odd");
        else
            System.out.println("Even");

        if ((a/2)*2 == a)
            System.out.println("Even");
        else
            System.out.println("Odd");
    }
}
