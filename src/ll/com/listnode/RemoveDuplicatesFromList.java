package ll.com.listnode;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesFromList {
    public static class Node {
        int val;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
    public static Node deleteDuplicates(Node head) {
        // Use a HashMap to count occurrences of each value
        Map<Integer, Integer> countMap = new HashMap<>();
        Node current = head;

        // First pass: Count occurrences of each value
        while (current != null) {
            countMap.put(current.val, countMap.getOrDefault(current.val, 0) + 1);
            current = current.next;
        }

        // Dummy node to handle edge cases
        Node dummy = new Node(0, head);
        Node prev = dummy;
        current = head;

        // Second pass: Remove nodes with duplicate values
        while (current != null) {
            if (countMap.get(current.val) > 1) {
                // Skip the current node if its value is a duplicate
                prev.next = current.next;
            } else {
                // Move prev pointer if current node is unique
                prev = current;
            }
            current = current.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Example: 1 -> 1 -> 2 -> 3 -> 3
//        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));

        // Example: 1 -> 2 -> 1 -> 3 -> 2
        Node head = new Node(1, new Node(2, new Node(1, new Node(3, new Node(2)))));

        // Process the list
        Node result = deleteDuplicates(head);

        // Print the result
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
        System.out.println("null");
    }
}