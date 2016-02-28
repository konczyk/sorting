import java.util.Comparator;

/**
 * Sorts an array using insertion sort algorithm
 */
public class Insertion {

    // sort input array using natural order
    public static <T extends Comparable<T>> void sort(T[] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = i; j > 0 && input[j].compareTo(input[j-1]) < 0; j--) {
                swap(input, j, j-1);
            }
        }
    }

    // sort input array using comparator
    public static <T> void sort(T[] input, Comparator<T> comp) {
        for (int i = 0; i < input.length; i++) {
            for (int j = i; j > 0 && comp.compare(input[j], input[j-1]) < 0; j--) {
                swap(input, j, j-1);
            }
        }
    }

    // swap input array items indexed by i and j
    private static void swap(Object[] input, int i, int j) {
        Object tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }
}
