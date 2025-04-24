package ll.com.listnode;

/**
 * 找到链表的中间节点
 */
public class FindMiddleNode {
    public static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static Node findMiddleNode(Node head) {
        if (head == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        // 快慢指针移动
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        // 创建测试链表 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // 找到中间节点
        Node middle = findMiddleNode(head);

        // 打印结果
        System.out.println("中间节点的值是: " + (middle != null ? middle.val : "null"));
    }
}
