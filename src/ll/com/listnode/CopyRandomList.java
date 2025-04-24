package ll.com.listnode;

public class CopyRandomList {
    public static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: 在原链表中插入复制节点
        Node current = head;
        while (current != null) {
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }

        // Step 2: 设置复制节点的 random 指针
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Step 3: 拆分链表
        Node original = head;
        Node copyHead = head.next;
        Node copyCurrent = copyHead;

        while (original != null) {
            original.next = original.next.next;
            if (copyCurrent.next != null) {
                copyCurrent.next = copyCurrent.next.next;
            }
            original = original.next;
            copyCurrent = copyCurrent.next;
        }

        return copyHead;
    }

    // 测试
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.next = node2;
        node2.next = node3;

        node1.random = node3; // 1 -> random -> 3
        node2.random = node1; // 2 -> random -> 1

        Node copyHead = copyRandomList(node1);

        // 打印原链表
        System.out.println("Original List:");
        printList(node1);

        // 打印复制链表
        System.out.println("Copied List:");
        printList(copyHead);
    }

    private static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print("Node: " + current.val);
            if (current.random != null) {
                System.out.print(", Random: " + current.random.val);
            } else {
                System.out.print(", Random: null");
            }
            System.out.println();
            current = current.next;
        }
    }
}
