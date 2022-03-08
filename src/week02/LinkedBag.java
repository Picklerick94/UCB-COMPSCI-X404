package week02;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedBag<Item> implements Iterable<Item> {
    private Node head;
    private int numOfItems;

    private class Node {
        private Item item;
        private Node next;
    }

    /**
     * Create a new bag
     */
    public LinkedBag() {
        head = null;
        numOfItems = 0;
    }

    /**
     * Is the bag empty?
     * @return true if the bag is empty
     */
    private boolean isBagEmpty() {
        return head == null;
    }

    /**
     * Number of items in the bag.
     * @return Number of items in the bag
     */
    public int getSizeOfBag() {
        return numOfItems;
    }

    /**
     * Add an item to the bag.
     * @param item the item to be added
     */
    public void add(Item item) {
        Node prev = head;
        head = new Node();
        head.item = item;
        head.next = prev;
        numOfItems++;
    }

    /**
     * Clear the bag
     */
    public void clear() {
        head = null;
    }

    public Iterator<Item> iterator()  {
        return new LinkedIterator();
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node current;

        public LinkedIterator() {
            current = head;
        }

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {}
    }

    /**
     * Test cases
     */
    public static void main(String[] args) {
        LinkedBag<String> bag = new LinkedBag<>();

        String[] testValues = {"a", "b", "c", "a", "a"};
        for (String testValue : testValues) {
            bag.add(testValue);
        }

        System.out.println("The size of a bag is: " + bag.getSizeOfBag());
        System.out.println("Is bag empty? " + bag.isBagEmpty());

        for (String s : bag) {
            System.out.println(s);
        }

        bag.clear();
        System.out.println("Is bag cleared? " + bag.isBagEmpty());
    }
}