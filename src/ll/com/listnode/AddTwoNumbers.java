package ll.com.listnode;

public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // 虚拟头节点
        ListNode current = dummyHead; // 当前节点
        int carry = 0; // 进位

        // 遍历两个链表，直到都为空且没有进位
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0; // 链表1当前节点值
            int val2 = (l2 != null) ? l2.val : 0; // 链表2当前节点值

            int sum = val1 + val2 + carry; // 当前位的和
            carry = sum / 10; // 更新进位
            current.next = new ListNode(sum % 10); // 创建新节点存储当前位结果

            current = current.next; // 移动到下一个节点
            if (l1 != null) {
                l1 = l1.next; // 链表1移动
            }
            if (l2 != null) {
                l2 = l2.next; // 链表2移动
            }
        }

        return dummyHead.next; // 返回结果链表
    }

    // 测试
    public static void main(String[] args) {
        // 链表1: 2 -> 4 -> 3 表示数字 342
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // 链表2: 5 -> 6 -> 4 表示数字 465
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // 计算和
        ListNode result = addTwoNumbers(l1, l2);

        // 打印结果
        System.out.println("Result:");
        printList(result); // 应输出: 7 -> 0 -> 8 表示数字 807
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}