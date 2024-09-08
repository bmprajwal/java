package dsa.arrays;

public class MaxAppearing {
    static final int MAX = 1000;
    public static void main(String[] args) {
        int[] L = { 1, 5, 9, 13, 21 };
        int[] R = { 15, 8, 12, 20, 30 };

        System.out.println(maximumOccurredElement(L, R));
    }
    static int maximumOccurredElement(int[] L, int[] R){
        int[] freq = new int[MAX];
        int maxi = -1;
        for (int i = 0; i < L.length; i++) {
            freq[L[i]]++;
            freq[R[i]+1]--;
            if(R[i] > maxi){
                maxi = R[i];
            }
        }
        int ans = Integer.MIN_VALUE;
        int res = -1;
        for (int i = 1; i <= maxi; i++) {
            freq[i] = freq[i] + freq[i-1];
            if(freq[i] > ans){
                ans = freq[i];
                res = i;
            }
        }
        return res;
    }
}
