package week03;

public class DoublyLinkedList<Item> {
    private Node head;

    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }

    /**
     * Create a list with three nodes.
     */
    public void buildList(Item first, Item second, Item third) {
        Node one = new Node();
        one.item = first;
        Node two = new Node();
        two.item = second;
        Node three = new Node();
        three.item = third;
        one.next = two;
        one.prev = null;
        two.next = three;
        two.prev = one;
        three.next = null;
        three.prev = two;
        head = one;
    }

    /**
     * Insert a node in the beginning
     */
    public void addToFront(Item item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = head;
        newNode.prev = null;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }

    /**
     * Append a node at the end
     */
    public void addToEnd(Item item) {
        Node newNode = new Node();
        newNode.item = item;
        Node last = head;
        newNode.next = null;
        if (head == null) {
            newNode.prev = null;
            head = newNode;
            return;
        }
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
        newNode.prev = last;
    }

    /**
     * Purge the list completely
     */
    public void purgeNodes() {
        Node temp = new Node();
        while (head != null) {
            temp = head;
            head = head.next;
            temp = null;
        }
        System.out.println("List has been cleaned.");
    }

    public void display() {
        Node curr = head;
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        while (curr != null) {
            System.out.println(curr.item);
            curr = curr.next;
        }
    }

    /**
     * Test cases
     */
    public static void main(String[] args) {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.buildList("b", "c", "d");
        list.display();

        System.out.println("Add a node to front:");
        list.addToFront("a");
        list.display();

        System.out.println("Append a node to end:");
        list.addToEnd("e");
        list.display();

        System.out.println("Clear all nodes:");
        list.purgeNodes();
        list.display();
    }
}
