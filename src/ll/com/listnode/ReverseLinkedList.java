package ll.com.listnode;

// 反转双向链表
public class ReverseLinkedList {
    public static class DoubleNode {
       private int val;
       private DoubleNode prev;
       private DoubleNode next;
       public DoubleNode(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    public static class SinglyNode {
        private int val;
        private SinglyNode next;

        public SinglyNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static DoubleNode reverseDoubleLinkedList(DoubleNode head) {
        DoubleNode current = head;
        DoubleNode newHead = null;

        while (current != null) {
            // 交换 prev 和 next 指针
            DoubleNode temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            newHead = current; // 更新新的头节点
            current = current.prev; // 前进到下一个节点
        }

        return newHead; // 返回反转后的新头节点
    }

    public static SinglyNode reverseSinglyListNode(SinglyNode head) {
        SinglyNode prev = null;
        SinglyNode current = head;
        while (current != null) {
            SinglyNode next = current.next; // 保存下一个节点
            current.next = prev;     // 当前节点指向前一个节点
            prev = current;          // 前一个节点向后移动
            current = next;          // 当前节点向后移动
        }
        return prev; // 新的头节点
    }

    public static void printDoubleList(DoubleNode head) {
        DoubleNode current = head;
        while (current != null) {
            System.out.print(current.val + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void printSinglyList(SinglyNode head) {
        SinglyNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // 创建双向链表 1 <-> 2 <-> 3 <-> 4 <-> null
        DoubleNode doubleHead = new DoubleNode(1);
        DoubleNode second = new DoubleNode(2);
        DoubleNode third = new DoubleNode(3);
        DoubleNode fourth = new DoubleNode(4);

        doubleHead.next = second;
        second.prev = doubleHead;
        second.next = third;
        third.prev = second;
        third.next = fourth;
        fourth.prev = third;

        System.out.println("Original List:");
        printDoubleList(doubleHead);

        doubleHead = reverseDoubleLinkedList(doubleHead);

        System.out.println("Reversed List:");
        printDoubleList(doubleHead);

        System.out.println("==========================");

        // 创建单向链表 1 -> 2 -> 3 -> 4 -> null
        SinglyNode singlyHead = new SinglyNode(1);
        singlyHead.next = new SinglyNode(2);
        singlyHead.next.next = new SinglyNode(3);
        singlyHead.next.next.next = new SinglyNode(4);

        System.out.println("Original List:");
        printSinglyList(singlyHead);

        singlyHead = reverseSinglyListNode(singlyHead);

        System.out.println("Reversed List:");
        printSinglyList(singlyHead);
    }
}
