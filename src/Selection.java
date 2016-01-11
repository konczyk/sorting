import java.util.Comparator;

/**
 * Sorts an array using selection sort algorithm
 */
public class Selection {

    // sort input array using natural order
    public static void sort(Comparable[] input) {
        int inputLength = input.length;
        for (int i = 0; i < inputLength; i++) {
            int min = i;
            for (int j = i + 1; j < inputLength; j++) {
                // check if item is less than current min
                if (input[j].compareTo(input[min]) < 0) {
                    min = j;
                }
            }
            // swap current item with min
            swap(input, i, min);
        }
    }

    // sort input array using comparator
    public static void sort(Object[] input, Comparator comp) {
        int inputLength = input.length;
        for (int i = 0; i < inputLength; i++) {
            int min = i;
            for (int j = i + 1; j < inputLength; j++) {
                // check if item is less than current min
                if (comp.compare(input[j], input[min]) < 0) {
                    min = j;
                }
            }
            // swap current item with min
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
