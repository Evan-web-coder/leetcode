package ll.com.listnode;

import java.util.PriorityQueue;

/**
 * 合并k个有序链表
 */
public class MergeKSortedLists {
    public static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // 使用优先队列合并 K 个有序链表
    public static Node mergeKLists(Node[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // 创建最小堆，按照节点值排序
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // 将每个链表的头节点加入堆
        for (Node node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }

        // 虚拟头节点，便于处理
        Node dummy = new Node(0);
        Node current = dummy;

        // 从堆中取出最小节点，接入结果链表
        while (!minHeap.isEmpty()) {
            Node smallest = minHeap.poll();
            current.next = smallest;
            current = current.next;

            // 将取出节点的下一个节点加入堆
            if (smallest.next != null) {
                minHeap.add(smallest.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // 创建测试链表
        Node l1 = new Node(1);
        l1.next = new Node(4);
        l1.next.next = new Node(5);

        Node l2 = new Node(1);
        l2.next = new Node(3);
        l2.next.next = new Node(4);

        Node l3 = new Node(2);
        l3.next = new Node(6);

        Node[] lists = {l1, l2, l3};

        // 合并链表
        Node mergedList = mergeKLists(lists);

        // 打印结果
        while (mergedList != null) {
            System.out.print(mergedList.val + " -> ");
            mergedList = mergedList.next;
        }
        System.out.println("null");
    }
}
