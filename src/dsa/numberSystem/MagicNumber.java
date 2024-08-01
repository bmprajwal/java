package dsa.numberSystem;

public class MagicNumber {
    public static void main(String[] args) {
        System.out.println(magicNo(3));
    }

    private static int magicNo(int i) {
        int ans = 0;
        int base = 5;
        while (i > 0){
            int last = i & 1;
            i = i >> 1;
            ans += base * last;
            base = base * 5;
        }
        return ans;
    }
}
