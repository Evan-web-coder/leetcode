package ll.com.itemtest;

// Write a class to implement a queue using linked lists with methods for enqueue, dequeue, and peek.
public class LinkedQueue {
    // 内部节点类
    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private Node front; // 队头
    private Node rear;  // 队尾

    // 入队
    public void enqueue(int val) {
        Node newNode = new Node(val);
        if (rear != null) {
            rear.next = newNode;
        }
        rear = newNode;

        if (front == null) {
            front = newNode;
        }
    }

    // 出队
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }

        int value = front.val;
        front = front.next;

        if (front == null) {
            rear = null; // 队列清空时，rear 也置空
        }

        return value;
    }

    // 查看队头元素
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return front.val;
    }

    // 判断是否为空
    public boolean isEmpty() {
        return front == null;
    }

    // 示例测试
    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("队头元素: " + queue.peek());   // 10
        System.out.println("出队元素: " + queue.dequeue()); // 10
        System.out.println("队头元素: " + queue.peek());   // 20
        System.out.println("队列是否为空: " + queue.isEmpty()); // false
    }
}
