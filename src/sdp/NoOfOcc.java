package sdp;

import java.util.Arrays;

public class NoOfOcc {
    public static void main(String[] args) {
        String str = "aaAbBbCde".toLowerCase();
        int[] countArr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            countArr[ - a]++;
        }
        System.out.println(Arrays.toString(countArr));
    }
}
