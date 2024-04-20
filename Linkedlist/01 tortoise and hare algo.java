// Definition for a singly-linked list node
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {

    // Function to detect a loop in a linked list using Floyd's Cycle-Finding Algorithm
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false; // No loop if the linked list has less than 2 nodes
        }

        ListNode slowPointer = head; // Initialize slow pointer to head
        ListNode fastPointer = head; // Initialize fast pointer to head

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next; // Move slow pointer one node at a time
            fastPointer = fastPointer.next.next; // Move fast pointer two nodes at a time

            if (slowPointer == fastPointer) {
                return true; // If pointers meet, there's a loop
            }
        }

        return false; // If fast pointer reaches the end, no loop
    }

    // Main function to test the implementation
    public static void main(String[] args) {
        // Example input: 1 -> 2 -> 3 -> 2 (creating a loop)
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head.next; // Creating a loop

        // Check if the linked list has a loop
        boolean hasLoop = hasCycle(head);
        System.out.println("Does the linked list have a loop? " + hasLoop); // Output: true
    }
}
