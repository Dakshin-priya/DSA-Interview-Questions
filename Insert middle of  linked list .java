class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // Function to insert a node in the middle
    public void insertMiddle(int data) {
        Node newNode = new Node(data);

        // If list is empty
        if (head == null) {
            head = newNode;
            return;
        }

        Node slow = head;
        Node fast = head;

        // Find middle using slow-fast pointer
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Insert after middle
        newNode.next = slow.next;
        slow.next = newNode;
    }

    // Function to print list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Create sample list: 1->2->3->4->null
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);

        System.out.println("Original list:");
        list.printList();

        // Insert 99 in the middle
        list.insertMiddle(99);

        System.out.println("After inserting in middle:");
        list.printList();
    }
}
