package ll.com.listnode;

// 合并两个有序链表
public class MergeSortedLists {
    public static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static Node mergeTwoLists(Node l1, Node l2) {
        // 创建一个虚拟头节点，方便操作
        Node dummy = new Node(-1);
        Node current = dummy;

        // 合并两个链表
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // 连接剩余的节点
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        // 返回合并后的链表头节点
        return dummy.next;
    }

    public static Node merge(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return head1 != null ? head1 : head2;
        }
        Node head = head1.val < head2.val ? head1 : head2;
        Node cur1 = head == head1 ? head1 : head2;
        Node cur2 = head == head1 ? head2 : head1;
        Node pre = null;
        Node next = null;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                pre = cur1;
                cur1 = cur1.next;
            } else {
                next = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                pre = cur2;
                cur2 = next;
            }
        }
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }

    public static Node mergeTwoListsRecursive(Node l1, Node l2) {
        // 递归终止条件
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // 比较两个链表的当前节点值，递归处理较小节点的后续部分
        if (l1.val <= l2.val) {
            l1.next = mergeTwoListsRecursive(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsRecursive(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        // 示例测试
        Node l1 = new Node(1);
        l1.next = new Node(3);
        l1.next.next = new Node(5);

        Node l2 = new Node(2);
        l2.next = new Node(4);
        l2.next.next = new Node(6);

        Node merged = mergeTwoListsRecursive(l1, l2);

        // 打印结果
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
    }
}