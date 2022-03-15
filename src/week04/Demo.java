package week04;

/**
 * Demo<Key, Value> provides the basic implementation of the Map interface of Java.
 * It stores the data in (Key, Value) pairs.
 * Can access them by an index of another type.
 * One object is used as a key (index) to another object (value).
 */
import java.util.HashMap;

public class Demo {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");

        System.out.println("Size of the map:" + map.size());
        System.out.println(map);
    }
}
