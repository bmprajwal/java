package leetCode;

import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,2,3};
        System.out.println(findContentChildren(g, s));
    }
    public static int findContentChildren(int[] g, int[] s){
        Arrays.sort(g);
        Arrays.sort(s);
        int childIndex = 0;
        int cookieIndex = 0;
        while(cookieIndex < s.length && childIndex < g.length){
            if(g[childIndex] <= s[cookieIndex]) {
                childIndex++;
            }
            cookieIndex++;
        }
        return childIndex;
    }
}
