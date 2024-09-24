package thread;

public class MonitorLock{
    public synchronized void task1(){
        try{
            System.out.println("Inside task 1, before sleep");
            Thread.sleep(10000);
            System.out.println("Inside task 1, after sleep");
        } catch (Exception e){
            // exception handling
        }
    }

    public void task2(){
        System.out.println("Inside task 2, before sync");
        synchronized (this){
            System.out.println("Inside sync block");
        }
        System.out.println("Inside task 2, after sync");
    }
    public void task3(){
        System.out.println("Task 3");
    }

    public static void main(String[] args) {
        MonitorLock myobj = new MonitorLock();

        Thread thread1 = new Thread(myobj::task1);
        Thread thread2 = new Thread(myobj::task2);
        Thread thread3 = new Thread(myobj::task3);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
