package prajwal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main2 {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");
//
//        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
//        for (int i = 1; i <= 5; i++) {
//
//            // Press Shift+F9 to start debugging your code. We have set one breakpoint
//            // for you, but you can always add more by pressing Ctrl+F8.
//            System.out.println("i = " + i);

//        Queue<Integer> list = new LinkedList<>();
//        list.offer(19);
//        list.offer(9);
//        list.offer(29);
//        list.offer(49);
//        list.offer(69);
//        System.out.println(list.peek());

//        String s = "hello";
//        System.out.println((char) (s.charAt(0) - 65) );
        int[] nums = {0,1,2,3,4};
        int[] index = {0,1,2,2,1};
//        System.out.println(Arrays.toString(createTargetArray(nums, index)));
        StringBuffer str = new StringBuffer("Hello");
        StringBuffer first = str;
        first = first.reverse().append(str.reverse());
        System.out.println(str);

    }
    static public int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];
        int i = 0, k;
        while (i < nums.length) {
            for(k = nums.length - 1; k > index[i]; k--){
                target[k] = target[k -1];
            }
            target[k] = nums[i];
            i++;
        }

        return target;
    }
}