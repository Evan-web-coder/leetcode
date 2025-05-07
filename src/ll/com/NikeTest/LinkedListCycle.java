package ll.com.NikeTest;

// Implement a function to detect if a linked list has a cycle. If there is a cycle, return the node where the cycle begins. Otherwise, return `None`.
public class LinkedListCycle {
    // 定义链表节点结构
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 检测链表是否有环，如果有，返回环起始节点；否则返回 null
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // 第一步：判断是否有环（快慢指针相遇）
        while (fast != null && fast.next != null) {
            slow = slow.next;         // 慢指针走一步
            fast = fast.next.next;    // 快指针走两步

            if (slow == fast) {
                // 有环，进行第二步
                break;
            }
        }

        // 没有环
        if (fast == null || fast.next == null) {
            return null;
        }

        // 第二步：找环的起点
        ListNode start = head;
        while (start != slow) {
            start = start.next;
            slow = slow.next;
        }

        return start; // 此时 start 和 slow 都在环的起始点
    }
}
