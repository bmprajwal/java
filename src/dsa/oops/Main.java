package dsa.oops;

public class Main {
    public static void main(String[] args) {
        Student prajwal = new Student();
        for (int i = 0; i < 1000000000; i++) {
            prajwal = new Student();
        }
        prajwal.greet();
    }
}

class Student {
    int rno;
    String name;
    float marks;

    Student(){
        this (10, "some name", 50.0f);
    }
    Student(int rno, String name, float marks){
        this.rno = rno;
        this.name = name;
        this.marks = marks;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object destroyed");
    }

    void greet(){
        System.out.println("Hello my name is " + this.name);
    }
}
