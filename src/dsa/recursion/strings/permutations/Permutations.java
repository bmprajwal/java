package dsa.recursion.strings.permutations;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
//        permutations("", "abc");
        System.out.println(permutationsList("", "abcd"));
    }

    static void permutations(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0,i);
            String second = p.substring(i);
            permutations(first+ch+second, up.substring(1));
        }
    }

    static List<String> permutationsList(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();

        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0,i);
            String second = p.substring(i);
            list.addAll(permutationsList(first+ch+second, up.substring(1)));
        }
        return list;
    }
}
