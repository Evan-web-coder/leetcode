package ll.com.listnode;

/**
 * 判断链表中是否有环
 */
public class LinkedListCycle {
    public static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }

        // 使用快慢指针
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;       // 慢指针每次走一步
            fast = fast.next.next;  // 快指针每次走两步

            if (slow == fast) { // 快慢指针相遇，说明有环
                return true;
            }
        }

        return false; // 快指针走到 null，说明无环
    }

    // 判断链表是否有环，并返回相遇点
    public static Node detectCycle(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // 有环，返回相遇点
                return slow;
            }
        }
        return null; // 无环
    }

    // 找到环的入口
    public static Node findCycleEntry(Node head) {
        Node meetingPoint = detectCycle(head);
        if (meetingPoint == null) {
            return null; // 无环
        }

        Node slow = head;
        Node fast = meetingPoint;

        // 从链表头部和相遇点同时出发，最终相遇的点是环的入口
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow; // 环的入口
    }

    // 计算环的长度
    public static int calculateCycleLength(Node head) {
        Node meetingPoint = detectCycle(head);
        if (meetingPoint == null) {
            return 0; // 无环
        }

        int length = 0;
        Node current = meetingPoint;

        do {
            current = current.next;
            length++;
        } while (current != meetingPoint);

        return length; // 环的长度
    }

    public static void main(String[] args) {
        // 创建测试链表：1 -> 2 -> 3 -> 4 -> 5 -> 2 (有环)
        Node singlyNode1 = new Node(1);
        Node singlyNode2 = new Node(2);
        Node singlyNode3 = new Node(3);
        Node singlyNode4 = new Node(4);
        Node singlyNode5 = new Node(5);

        singlyNode1.next = singlyNode2;
        singlyNode2.next = singlyNode3;
        singlyNode3.next = singlyNode4;
        singlyNode4.next = singlyNode5;
        singlyNode5.next = singlyNode2; // 构成环

        System.out.println("链表是否有环: " + hasCycle(singlyNode1)); // 输出: true
    }
}
