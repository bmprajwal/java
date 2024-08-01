package dsa.recursion.strings;

public class SkipAChar {
    public static void main(String[] args) {
//        String str = "baccad";
//        String ans = build2(str);
//        System.out.println(ans);

        String str = "bdapplekdsf";
        String ans = skipApple(str);
        System.out.println(ans);
    }

    static String build(String str , String ans){
        if (str.isEmpty()){
            return ans;
        }

        if(str.charAt(0) != 'a'){
            ans += str.charAt(0);
            return build(str.substring(1), ans);
        } else {
            return build(str.substring(1), ans);
        }
    }

    static String build2(String str){
        if (str.isEmpty()){
            return "";
        }

        char ch = str.charAt(0);
        if(ch != 'a'){
            return ch + build2(str.substring(1));
        } else {
            return build2(str.substring(1));
        }
    }

    static String skipApple(String str){
        if(str.isEmpty()){
            return "";
        }

        if(str.startsWith("apple")){
            return skipApple(str.substring(5));
        }
        return str.charAt(0) + skipApple(str.substring(1));
    }


}
