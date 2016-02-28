import java.util.Comparator;

/**
 * Sorts an array using selection sort algorithm
 */
public class Selection {

    // sort input array using natural order
    public static <T extends Comparable<T>> void sort(T[] input) {
        int inputLength = input.length;
        for (int i = 0; i < inputLength; i++) {
            int min = i;
            for (int j = i + 1; j < inputLength; j++) {
                if (input[j].compareTo(input[min]) < 0) {
                    min = j;
                }
            }
            swap(input, i, min);
        }
    }

    // sort input array using comparator
    public static <T> void sort(T[] input, Comparator<T> comp) {
        int inputLength = input.length;
        for (int i = 0; i < inputLength; i++) {
            int min = i;
            for (int j = i + 1; j < inputLength; j++) {
                if (comp.compare(input[j], input[min]) < 0) {
                    min = j;
                }
            }
            swap(input, i, min);
        }
    }

    // swap input array items indexed by i and j
    private static void swap(Object[] input, int i, int j) {
        Object tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }
}
