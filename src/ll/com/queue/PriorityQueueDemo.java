package ll.com.queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        minHeap.add(10);
        minHeap.add(5);
        minHeap.add(20);
        minHeap.add(1);
        
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll()); // 输出顺序：1, 5, 10, 20
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.add(10);
        maxHeap.add(5);
        maxHeap.add(20);
        maxHeap.add(1);

        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll()); // 输出顺序：20, 10, 5, 1
        }
    }
}
