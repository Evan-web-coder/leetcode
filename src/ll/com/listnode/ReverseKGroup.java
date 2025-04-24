package ll.com.listnode;

/**
 * K 个一组反转链表
 */
public class ReverseKGroup {
    public static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static Node reverseKGroup(Node head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        // 虚拟头节点
        Node dummy = new Node(0);
        dummy.next = head;

        Node prev = dummy;
        Node end = dummy;

        while (true) {
            // 移动 `end` 指针到 K 个节点处
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break; // 不足 K 个节点
            }

            // 保存下一组的起始节点
            Node nextGroup = end.next;
            // 当前组的起点
            Node start = prev.next;

            // 断开当前组与后续部分的连接
            end.next = null;

            // 反转当前组
            prev.next = reverse(start);

            // 将当前组的尾部连接到下一组的头部
            start.next = nextGroup;

            // 移动 prev 和 end 到下一组的起始位置
            prev = start;
            end = start;
        }

        return dummy.next;
    }

    private static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        // 测试单向链表
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original Single Linked List:");
        printSingleList(head);

        head = reverseKGroup(head, 3);

        System.out.println("Reversed in Groups of 3:");
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
