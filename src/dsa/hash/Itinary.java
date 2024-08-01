package dsa.hash;

import java.util.HashMap;

public class Itinary {
    public static void main(String[] args) {
        HashMap<String, String> routes = new HashMap<>();

        routes.put("Chennai", "Bengaluru");
        routes.put("Mumbai", "Delhi");
        routes.put("Goa", "Chennai");
        routes.put("Delhi", "Goa");

        String start = getStart(routes);
        while (routes.containsKey(start)){
            System.out.print(start + " -> ");
            start = routes.get(start);
        }
        System.out.println(start);
    }
    public static String getStart(HashMap<String, String> routes){
        HashMap<String,String> revRoutes = new HashMap<>();
        for(String key: routes.keySet()){
            revRoutes.put(routes.get(key), key);
        }
        for(String key: routes.keySet()){
            if(!revRoutes.containsKey(key)){
                return key;
            }
        }
        return null;
    }
}
