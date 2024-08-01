package dsa.hash;

import java.util.HashSet;
import java.util.Iterator;

public class Hashset {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(4);
        set.add(9);
        set.add(2);
        set.add(4);
        System.out.println(set);

        System.out.println(set.contains(3));
        System.out.println(set.remove(2));
        System.out.println(set);
        System.out.println(set);
//        Iterator<Integer> it = set.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next());
//        }

    }
}
