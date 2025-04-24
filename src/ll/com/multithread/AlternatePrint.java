package ll.com.multithread;

public class AlternatePrint {
    private static final Object lock = new Object();
    private static boolean isATurn = true; // 初始由A线程先打印

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 10; i++) { // 打印10次A
                synchronized (lock) {
                    while (!isATurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.print("A");
                    isATurn = false;
                    lock.notifyAll();
                }
            }
        });

        Thread threadB = new Thread(() -> {
            for (int i = 0; i < 10; i++) { // 打印10次B
                synchronized (lock) {
                    while (isATurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.print("B");
                    isATurn = true;
                    lock.notifyAll();
                }
            }
        });

        threadA.start();
        threadB.start();
    }
}
