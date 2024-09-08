package prajwal;

import java.io.IOException;

public class HelloWorld {
    public static void main(String[] args) {
        String name = new String("Prajwal");
        name = null;
        System.gc();
    }

}
