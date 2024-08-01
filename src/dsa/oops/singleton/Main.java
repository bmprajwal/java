package dsa.oops.singleton;

public class Main {
    public static void main(String[] args) {
        Singleton obj = Singleton.getInstance();
        obj.message();

        Singleton obj2 = Singleton.getInstance();
        obj.name = "Rahul";
        obj2.message();
    }
}
