package ll.com.listnode;

/**
 * 删除链表的倒数第N个节点
 */
public class RemoveNthNode {
    public static class Node {
        private int val;
        private Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static Node removeNthFromEnd(Node head, int n) {
        if (head == null || n <= 0) {
            return head;
        }

        // 虚拟头节点，方便处理删除头节点的情况
        Node dummy = new Node(0);
        dummy.next = head;

        Node fast = dummy;
        Node slow = dummy;

        // 快指针先移动 n 步
        for (int i = 0; i < n; i++) {
            if (fast.next == null) {
                return head; // n 超出链表长度
            }
            fast = fast.next;
        }

        // 快慢指针同时移动，直到快指针到达链表末尾
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 删除目标节点
        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        // 创建测试链表 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // 删除倒数第 2 个节点
        head = removeNthFromEnd(head, 2);

        // 打印结果
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
