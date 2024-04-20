import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListCycleTest {

    @Test
    void testHasCycleWithCycle() {
        // Example input: 1 -> 2 -> 3 -> 2 (creating a loop)
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head.next; // Creating a loop

        // Check if the linked list has a loop
        boolean hasLoop = LinkedListCycle.hasCycle(head);
        assertTrue(hasLoop, "Linked list should have a loop");
    }

    @Test
    void testHasCycleWithoutCycle() {
        // Example input: 1 -> 2 -> 3 -> null (no loop)
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        // Check if the linked list has a loop
        boolean hasLoop = LinkedListCycle.hasCycle(head);
        assertFalse(hasLoop, "Linked list should not have a loop");
    }
}
