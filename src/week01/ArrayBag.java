package week01;

public class ArrayBag implements Bag {
    private final Object[] items;
    private int numOfItems;
    public static final int DEFAULT_CAPACITY = 50;

    /**
     * Create a new bag with default maximum size.
     */
    public ArrayBag() {
        items = new Object[DEFAULT_CAPACITY];
        numOfItems = 0;
    }

    /**
     * Create a new bag with specified
     * maximum size.
     */
    public ArrayBag(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("max size must be larger than 0");
        }
        this.items = new Object[maxSize];
        this.numOfItems = 0;
    }

    private boolean isBagFull() {
        return numOfItems == items.length;
    }

    private boolean isBagEmpty() {
        return numOfItems == 0;
    }

    /**
     * @return number of items in a bag
     */
    public int getSizeOfBag() {
        return numOfItems;
    }

    /**
     * Add items to a bag.
     * @return true if there is room to add it, and false otherwise.
     */
    public boolean add(Object item) {
        if (item == null) {
            throw new IllegalArgumentException("item can not be null");
        } else if (isBagFull()) {
            return false;
        } else {
            this.items[this.numOfItems] = item;
            this.numOfItems++;
            return true;
        }
    }

    /**
     * Remove an item from a bag.
     * @return true if succeeded, and false otherwise.
     */
    public boolean remove(Object item) {
        for (int i = 0; i < this.numOfItems; i++) {
            if (this.items[i].equals(item)) {
                this.items[i] = this.items[this.numOfItems - 1];
                this.items[this.numOfItems - 1] = null;
                this.numOfItems--;
                return true;
            }
        }
        return false;
    }

    /**
     * Clear this ArrayBag
     */
    public void clear() {
        while (!isBagEmpty()) {
            items[numOfItems - 1] = null;
            numOfItems--;
        }
    }

    /**
     * Get the frequency of an item
     * @return number of frequency
     */
    public int getFrequencyOf(Object item) {
        int counter = 0;
        for (int i = 0; i < numOfItems; i++) {
            if (this.items[i].equals(item)) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * If the bag contains the specified item.
     * @return if the bag contains the specified item.
     */
    public boolean contains(Object item) {
        for (int i = 0; i < this.numOfItems; i++) {
            if (this.items[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Secure the bag
     * @return copy of a bag
     */
    public Object[] toArray() {
        Object[] bag = new Object[this.numOfItems];

        for (int i = 0; i < this.numOfItems; i++) {
            bag[i] = this.items[i];
        }
        return bag;
    }

    /**
     * Test cases
     */
    public static void main(String[] args) {
        ArrayBag bag = new ArrayBag();

        String[] testValues = {"a", "b", "c", "a", "a"};

        for (String testValue : testValues) bag.add(testValue);

        Object[] items = bag.toArray();
        for (Object item : items) {
            System.out.println(item);
        }
        System.out.println("Is bag full: " + bag.isBagFull());
        System.out.println("Bag size: " + bag.getSizeOfBag());

        bag.remove("c");
        System.out.println("Does bag contain c? " + bag.contains("c"));

        System.out.println("Frequency of a? " + bag.getFrequencyOf("a"));

        bag.clear();
        System.out.println("Bag cleared? " + bag.isBagEmpty());
    }
}