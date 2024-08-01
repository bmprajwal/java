package dsa.oops.singleton;

public class Singleton {

    String name;
    private Singleton(){
        this.name = "Prajwal";
    }

    void message(){
        System.out.println("Hello " + this.name);
    }

    public static Singleton instance;

    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
