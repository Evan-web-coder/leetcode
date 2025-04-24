package ll.com.listnode;

public class SortLinkedList {
    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
    public static Node sortList(Node head) {
        if (head == null || head.next == null) {
            return head; // 空链表或单节点链表无需排序
        }

        // 1. 分割链表
        Node mid = getMiddle(head);
        Node rightHead = mid.next;
        mid.next = null; // 切断链表

        // 2. 递归排序左右部分
        Node left = sortList(head);
        Node right = sortList(rightHead);

        // 3. 合并排序后的两部分
        return mergeTwoLists(left, right);
    }

    // 使用快慢指针找到链表中点
    private static Node getMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 合并两个有序链表
    private static Node mergeTwoLists(Node l1, Node l2) {
        Node dummy = new Node(0); // 虚拟头节点
        Node current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // 将剩余节点接入
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }

        return dummy.next;
    }

    // 测试
    public static void main(String[] args) {
        Node node1 = new Node(4);
        Node node2 = new Node(2);
        Node node3 = new Node(1);
        Node node4 = new Node(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println("Before Sorting:");
        printList(node1);

        Node sorted = sortList(node1);

        System.out.println("After Sorting:");
        printList(sorted);
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