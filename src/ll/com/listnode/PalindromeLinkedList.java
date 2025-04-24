package ll.com.listnode;

public class PalindromeLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // 空链表或单节点链表是回文
        }

        // 1. 使用快慢指针找到链表中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. 反转后半部分链表
        ListNode secondHalf = reverseList(slow);

        // 3. 比较前半部分和后半部分
        ListNode firstHalf = head;
        ListNode reversed = secondHalf;
        boolean isPalindrome = true;
        while (reversed != null) {
            if (firstHalf.val != reversed.val) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            reversed = reversed.next;
        }

        // 4. 可选：恢复链表
        reverseList(secondHalf);

        return isPalindrome;
    }

    // 反转链表
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }

    // 测试
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println("Is Palindrome: " + isPalindrome(node1)); // 输出: true
    }
}