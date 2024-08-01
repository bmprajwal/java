package sdp;

public class LongInt {
    final static int MOD = 1003;
    public static void main(String[] args) {
        String n1 = "100000000000000";
        String n2 = "100000000000002";
        int x = computeModulus(n1) % MOD;
        System.out.println(x);
        int y = computeModulus(n2) % MOD;
        System.out.println(y);
        int ans = (x + y) % MOD;
        System.out.println(ans);
        // (a+b)%M => (a%M + b%M) % M
    }

    static int computeModulus(String n){
        int res = 0;
        for (int i = 0; i < n.length(); i++) {
            res = (res * 10 + (n.charAt(i) - '0')) % MOD;
        }
        return res;
    }
}
