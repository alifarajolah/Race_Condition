import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    public static void main(String[] args) {
        IncrementThread thread1 = new IncrementThread();
        IncrementThread thread2 = new IncrementThread();

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter: " + IncrementThread.counter);
    }

    static class IncrementThread extends Thread {
        public static AtomicInteger counter = new AtomicInteger(0);

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet();
            }
        }
    }
}