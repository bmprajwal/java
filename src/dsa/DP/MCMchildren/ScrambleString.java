package dsa.DP.MCMchildren;

public class ScrambleString {
    public static void main(String[] args) {
        String a = "abcdbdacbdac";
        String b = "bdacabcdbdac";
        System.out.println(isScramble(a,b));
    }

    static boolean isScramble(String s1, String s2){
        if(s1.equals(s2)){
            return true;
        }

        if(s1.length() <= 1){
            return false;
        }

        int n = s1.length();
        boolean flag = false;

        for (int i = 1; i <= n-1; i++) {
            boolean swap = (isScramble(s1.substring(0,i), s2.substring(n-i)) && isScramble(s1.substring(i), s2.substring(0, n-i)));
            boolean noswap = (isScramble(s1.substring(0,i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)));

            if(swap || noswap){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
