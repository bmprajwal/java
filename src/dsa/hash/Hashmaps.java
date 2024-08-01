package dsa.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Hashmaps {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Prajwal", 210);
        map.put("Rahul", 250);
        System.out.println(map);
        Set<String> keys = map.keySet();
        for(String key: keys){
            System.out.println(key + " " + map.get(key));
        }


    }
}
