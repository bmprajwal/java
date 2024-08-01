package sdp;

import java.util.Scanner;

public class StringFactorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String arr = input.next();
        char[] str = arr.toCharArray();

        int strLength = str.length;
        int[] countArr = new int[26];

        for (int i = 0; i < strLength; i++) {
            countArr[str[i]-'a']++;
        }
        int den = 1;
        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] > 1){
                den *= fact(countArr[i]);
            }
        }
        int ans = fact(strLength) / den;
        System.out.println(ans);
    }

    public static int fact(int n){
        if (n == 1) return 1;
        else return n * fact(n-1);
    }
}
