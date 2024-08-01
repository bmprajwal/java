package dsa.recursion.easy;

public class Printing {
    public static void main(String[] args) {
        funMirror(5);
    }

    static void fun(int n){
        if(n == 0){
            return;
        }
        System.out.println(n  + " ");
        fun(n-1);
    }

    static void funRev(int n){
        if(n == 0){
            return;
        }
        funRev(n-1);
        System.out.println(n  + " ");
    }

    static void funMirror(int n){
        if(n == 0){
            return;
        }
        System.out.println(n + " ");
        funMirror(n-1);
        System.out.println(n  + " ");
    }

}
