public class ReverseLinkedList {
    
    // Function to reverse the linked list
    public static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;    // Store next node
            current.next = prev;    // Reverse current node's pointer
            prev = current;         // Move prev one step
            current = next;         // Move current one step
        }

        return prev; // New head of reversed list
    }
}
