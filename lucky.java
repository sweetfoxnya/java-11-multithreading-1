import java.util.concurrent.atomic.AtomicInteger;

public class lucky {
    static AtomicInteger countX = new AtomicInteger(0);
    static AtomicInteger count = new AtomicInteger(0);
    static class LuckyThread extends Thread {
        @Override
        public void run() {
                while (countX.get() < 999999) {
                    final int x = countX.incrementAndGet();
                    if ((x % 10) + (x / 10) % 10 + (x / 100) % 10 == (x / 1000)
                            % 10 + (x / 10000) % 10 + (x / 100000) % 10 && x <= 999999) {
                        System.out.println(x + " " + currentThread().getName());
                        count.incrementAndGet();
                    }
                }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new LuckyThread();
        t1.setName("Tr1");
        Thread t2 = new LuckyThread();
        t2.setName("Tr2");
        Thread t3 = new LuckyThread();
        t3.setName("Tr3");
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("Total: " + count);
    }
}
