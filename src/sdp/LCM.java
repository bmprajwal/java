package sdp;

import static sdp.HCF.calculateHCF;

public class LCM {
    public static void main(String[] args) {
        int a = 10;
        int b = 12;

        int max = Math.max(a,b);
        int lcm = max;

        while(true){
            if (lcm % a ==0 && lcm % b == 0){
                break;
            }
            lcm += max;
        }

        System.out.println(lcm);
    }

}
