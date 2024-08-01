package sdp;

import java.util.Arrays;
import java.util.Scanner;

public class StringReplace {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = input.next();
        char[] arr = str.toCharArray();
        char ch1 = input.next().charAt(0);
        char ch2 = input.next().charAt(0);
        String result = new String(ReplaceCharacter(arr, ch1, ch2));
        System.out.println(result);
    }
    public  static  char[] ReplaceCharacter(char[] str, char ch1, char ch2){
        char[] result = new char[str.length];
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ch1){
                result[i] = ch2;
            }
            else if (str[i] == ch2){
                result[i] = ch1;
            } else {
                result[i] = str[i];
            }

        }
        return result;
    }
}
