package thread;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource(3);

        Thread producer = new Thread(()->{
            for (int i = 1; i <= 6 ; i++) {
                sharedResource.produce(i);
            }
        });

        Thread consumer = new Thread(()-> {
            for (int i = 1; i <=6 ; i++) {
                sharedResource.consume();
            }
        });

        producer.start();
        consumer.start();
    }
}
