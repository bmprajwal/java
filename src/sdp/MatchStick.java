package sdp;

import java.util.Scanner;

public class MatchStick {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int totalMatchSticks = 21;
        int user, comp;
        while (true){
            System.out.println("No. of matches left: " + totalMatchSticks);
            System.out.print("Choose a number between 1 to 4:");
            user = input.nextInt();

            totalMatchSticks -= user;

            comp = 5 - user;
            System.out.println("Computer choose: " + comp);
            totalMatchSticks -= comp;

            if (totalMatchSticks == 1) {
                System.out.println("You lost");
                break;
            }


        }
    }
}
