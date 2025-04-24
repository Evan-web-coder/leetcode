package ll.com.listnode;

public class PartitionList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode partition(ListNode head, int x) {
        // 创建两个虚拟头节点
        ListNode lessHead = new ListNode(0); // 存储小于 x 的节点
        ListNode greaterHead = new ListNode(0); // 存储大于等于 x 的节点

        ListNode less = lessHead;
        ListNode greater = greaterHead;

        // 遍历链表并分配节点
        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }

        // 断开 greater 链表的尾节点，避免形成环
        greater.next = null;

        // 拼接两个链表
        less.next = greaterHead.next;

        return lessHead.next;
    }

    // 测试
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        System.out.println("Original List:");
        printList(node1);

        ListNode partitioned = partition(node1, 3);

        System.out.println("Partitioned List:");
        printList(partitioned);
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}