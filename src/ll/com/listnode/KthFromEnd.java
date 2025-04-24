package ll.com.listnode;

/**
 * 倒数第k的节点
 */
public class KthFromEnd {
    public static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode findKthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null; // 无效输入
        }

        ListNode fast = head;
        ListNode slow = head;

        // 1. 让 fast 指针先走 k 步
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null; // 如果 k 超过链表长度，直接返回 null
            }
            fast = fast.next;
        }

        // 2. 同时移动 fast 和 slow，直到 fast 到达链表末尾
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 3. slow 就是倒数第 k 个节点
        return slow;
    }

    // 测试代码
    public static void main(String[] args) {
        // 构建链表: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;
        ListNode result = findKthFromEnd(head, k);
        if (result != null) {
            System.out.println("倒数第 " + k + " 个节点的值是: " + result.val);
        } else {
            System.out.println("链表长度小于 " + k);
        }
    }
}
