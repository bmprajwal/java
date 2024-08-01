package sdp;

import java.util.Scanner;

public class Ovals {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char c = input.next().charAt(0);
        c = Character.toLowerCase(c);
        switch (c){
            case 'a', 'e', 'i', 'o', 'u':{
                System.out.println("Vowel");
                break;
            }
            default:
                System.out.println("Consonant");

        };
    }
}
