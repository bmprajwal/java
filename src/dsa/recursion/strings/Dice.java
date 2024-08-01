package dsa.recursion.strings;

import java.util.ArrayList;
import java.util.List;

public class Dice {
    public static void main(String[] args) {
//        dice("", 4);
        System.out.println(diceRet("", 5));
    }

    static void dice(String p, int target){
        if(target == 0){
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= 6 && i <= target; i++) {
            dice(p+i, target - i);
        }
    }

    static List<String> diceRet(String p, int target){
        if(target == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= 6 && i <= target; i++) {
            list.addAll(diceRet(p+i, target - i));
        }
        return list;
    }
}
