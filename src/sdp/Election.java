package sdp;

import java.util.Arrays;
import java.util.Scanner;

public class Election {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        int noOfCandidates = input.nextInt();
        int noOfBooths = input.nextInt();

        int[] votes = new int[noOfCandidates];
        int total = 0;
        for (int i = 0; i < noOfCandidates; i++) {
            for (int j = 0; j < noOfBooths; j++) {
                int x = input.nextInt();
                votes[i] += x;
                total += x;
            }
        }

        int m1, m2, m1i = 0, m2i = 0;
        m1 = -1;
        m2 = -2;
        for (int i = 0; i < votes.length; i++) {
            if (votes[i] > m1){
                m2 = m1;
                m2i = m1i;
                m1 = votes[i];
                m1i = i;

            } else {
                m2 = votes[i];
                m2i = i;
            }
        }

        if (votes[m1i] > total/2)
            System.out.println(('A'+ m1i) + " has won");
        else
            System.out.println("Runoff between " + ('A' + m1i) + " and " + ('A' + m2i));
    }


}
