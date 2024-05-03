public class DoublyLinkedList {

    // Node class to represent each element in the list
    private class Node {
        int data;
        Node prev;
        Node next;

        // Constructor to initialize a node with given data
        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // Head and tail pointers of the doubly linked list
    private Node head;
    private Node tail;

    // Constructor to initialize an empty doubly linked list
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Method to insert a new node at the end of the list
    public void insertEnd(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Method to delete a node from the end of the list
    public void deleteEnd() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        if (head == tail) {
            head = tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
    }

    // Method to check if the doubly linked list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Method to display the contents of the doubly linked list
    public void display() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        Node current = head;
        System.out.print("Doubly Linked List (forward): ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to display the contents of the doubly linked list in reverse order
    public void displayReverse() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        Node current = tail;
        System.out.print("Doubly Linked List (backward): ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertEnd(1);
        dll.insertEnd(2);
        dll.insertEnd(3);
        dll.insertEnd(15);
        dll.display();
        dll.deleteEnd();
        dll.display();
        dll.displayReverse();
    }
}
