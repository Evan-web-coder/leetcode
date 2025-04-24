package ll.com.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue<T> {
    private final Queue<T> queue = new LinkedList<>();
    private final int maxSize;
    private final int minSize;

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notTooEmpty = lock.newCondition();

    public BoundedBlockingQueue(int maxSize, int minSize) {
        if (minSize < 0 || maxSize <= minSize) {
            throw new IllegalArgumentException("Invalid minSize or maxSize");
        }
        this.maxSize = maxSize;
        this.minSize = minSize;
    }

    public void put(T item) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() > maxSize) {
                notFull.await();
            }
            queue.offer(item);
            notTooEmpty.signalAll(); // 唤醒等待消费的线程
        } finally {
            lock.unlock();
        }
    }

    public T take() throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() < minSize) {
                notTooEmpty.await();
            }
            T item = queue.poll();
            notFull.signalAll(); // 唤醒等待生产的线程
            return item;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }
}
