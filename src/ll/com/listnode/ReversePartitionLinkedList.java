package ll.com.listnode;

/**
 * 反转链表中从第 m 到第 n 的部分
 */
public class ReversePartitionLinkedList {
   public static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
   }

    public static Node reverseBetween(Node head, int m, int n) {
        if (head == null || m >= n) {
            return head;
        }

        // 虚拟头节点，用于简化边界处理
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        // 找到反转部分的起点前一个节点
        for (int i = 1; i < m; i++) {
            prev = prev.next;
        }

        // 当前指针指向反转部分的第一个节点
        Node current = prev.next;
        Node next;

        // 反转 m 到 n 的节点
        for (int i = 0; i < n - m; i++) {
            next = current.next;
            current.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // 单向链表测试
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original Single Linked List:");
        printSingleList(head);

        head = reverseBetween(head, 2, 4);

        System.out.println("Reversed Single Linked List:");
        printSingleList(head);
    }

    private static void printSingleList(Node head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
