package dsa.DP.MCMchildren;

class PalindromePartitioning {
    static Integer[][] t;
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(minCut(s));
    }
    public static int minCut(String s) {
        int n = s.length();
        t = new Integer[n][n];
        return solve(s, 0, n-1);

    }

    public static int solve(String s, int i, int j){
        if(i >= j){
            return 0;
        }

        if(isPalindrome(s, i, j)){
            return t[i][j] = 0;
        }

        if(t[i][j] != null){
            return t[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int k = i; k <= j-1; k++){
            if(isPalindrome(s, i, k)){
                int right = 0;

                if(t[k+1][j] != null){
                    right = t[k+1][j];
                } else {
                    right = solve(s, k+1, j);
                    t[k+1][j] = right;
                }
                int temp =  right + 1;
                min = Math.min(min, temp);
            }
        }
        return t[i][j] = min;
    }

    public static boolean isPalindrome(String s, int i, int j){
        if(i >= j){
            return true;
        }

        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}