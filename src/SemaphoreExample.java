import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    private static Semaphore semaphore = new Semaphore(1); // تعریف یک Semaphore با ظرفیت 1

    public static void main(String[] args) {
        Thread thread1 = new Thread(new IncrementThread());
        Thread thread2 = new Thread(new IncrementThread());

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

    static class IncrementThread implements Runnable {
        public static int counter = 0;

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                try {
                    semaphore.acquire(); // نگه‌دارنده Semaphore را بدست آورید
                    counter++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release(); // Semaphore را آزاد کنید
                }
            }
        }
    }
}