package sdp;

import java.util.Arrays;
import java.util.Scanner;

public class Vampire {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter total no. of people in the town: ");
        int n = input.nextInt();

        System.out.print("Enter the power values: ");
        String people = input.next();

        int[] intPeople = new int[people.length()];

        for (int i = 0; i < people.length(); i++) {
            intPeople[i] = Character.getNumericValue(people.charAt(i));
        }

        int max = Arrays.stream(intPeople).max().getAsInt();

        System.out.println(max);
    }
}
