class DoublyNode {
    int data;
    DoublyNode prev;
    DoublyNode next;

    DoublyNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DeleteMiddleDoublyLinkedList {

    public static DoublyNode deleteMiddle(DoublyNode head) {
        if (head == null || head.next == null) {
            // If list is empty or has one node
            return null;
        }

        DoublyNode slow = head;
        DoublyNode fast = head;

        // Find middle node
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete middle node (slow)
        if (slow.prev != null) slow.prev.next = slow.next;
        if (slow.next != null) slow.next.prev = slow.prev;

        return head;
    }

    public static void printList(DoublyNode head) {
        DoublyNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create list: 1 <-> 2 <-> 3 <-> 4 <-> 5
        DoublyNode head = new DoublyNode(1);
        head.next = new DoublyNode(2);
        head.next.prev = head;
        head.next.next = new DoublyNode(3);
        head.next.next.prev = head.next;
        head.next.next.next = new DoublyNode(4);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new DoublyNode(5);
        head.next.next.next.next.prev = head.next.next.next;

        System.out.println("Original List:");
        printList(head);

        head = deleteMiddle(head);

        System.out.println("After deleting middle:");
        printList(head);
    }
}
