package dsa.recursion.strings;

public class Reverse {
    public static void main(String[] args) {
        String name = "Prajwal is a good boy";
        System.out.println(rev(name));
    }
    static String rev(String up){
        if(up.isEmpty()){
            return "";
        }

        return rev(up.substring(1)) + up.charAt(0);
    }
}
