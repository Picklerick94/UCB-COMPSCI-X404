package week04;

/**
 * Description of insertion sort:
 * Move the larger items one position to the right
 * before inserting the current item into the vacated position.
 */

public class InsertionSort {
    private InsertionSort() {};

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(arr[j], arr[j - 1]); j--) {
                exchange(arr, j, j - 1);
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exchange(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printNumbs(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        String[] arr = {"S", "O", "R", "T"};
        InsertionSort.sort(arr);
        printNumbs(arr);
    }
}
