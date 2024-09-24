package thread;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    private Queue<Integer> sharedResource;
    private int bufferSize;

    public SharedResource(int bufferSize){
        sharedResource = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized void produce(int item){
        while(sharedResource.size() == bufferSize){
            System.out.println("Buffer is full, producer is waiting");
            try{
                wait();
            }catch (Exception e){
                //exception
            }
        }
        sharedResource.add(item);
        System.out.println("Produced: " + item);
        notify();
        try{
            Thread.sleep(100);
        } catch (Exception e){
            //
        }
    }

    public synchronized int consume(){
        while(sharedResource.isEmpty()){
            System.out.println("Buffer is empty, consumer is waiting");
            try{
                wait();
            }catch (Exception e){
                //exception
            }
        }

        int item = sharedResource.poll();
        System.out.println("Consumed: " + item);
        notify();
        try{
            Thread.sleep(150);
        } catch (Exception e){
            //
        }
        return item;
    }
}
