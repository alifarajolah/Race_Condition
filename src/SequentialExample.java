public class SequentialExample {
    public static void main(String[] args) {
        IncrementThread thread1 = new IncrementThread();
        IncrementThread thread2 = new IncrementThread();

        thread1.run();
        thread2.run();

        System.out.println("Counter: " + IncrementThread.counter);
    }

    static class IncrementThread {
        public static int counter = 0;

        public void run() {
            for (int i = 0; i < 1000; i++) {
                counter++;
            }
        }
    }
}