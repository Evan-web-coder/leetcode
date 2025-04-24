package ll.com.listnode;

public class RotateRight {
    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
    public static Node rotateRight(Node head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head; // 空链表或无需旋转
        }

        // Step 1: 计算链表长度
        Node current = head;
        int length = 1; // 链表长度
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Step 2: 优化 k 值
        k = k % length;
        if (k == 0) {
            return head; // k 为 0 时，无需旋转
        }

        // Step 3: 将链表变为环
        current.next = head; // 连接尾部和头部

        // Step 4: 找到新尾和新头
        int stepsToNewTail = length - k;
        Node newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }
        Node newHead = newTail.next;

        // Step 5: 断开环
        newTail.next = null;

        return newHead;
    }

    // 测试
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println("Original List:");
        printList(node1);

        Node rotated = rotateRight(node1, 2);

        System.out.println("Rotated List:");
        printList(rotated);
    }

    private static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}