package thread;

public class Multithreading implements Runnable {
    @Override
    public void run() {
        System.out.println("code executed by thread: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println("Inside main thread: " + Thread.currentThread().getName());
        Multithreading myThread = new Multithreading();
        Thread thread = new Thread(myThread);
        thread.start();
        System.out.println("Inside main thread: " + Thread.currentThread().getName());
    }
}
