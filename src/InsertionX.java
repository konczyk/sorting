/**
 * Sorts an array using insertion sort algorithm
 * Improved version with a sentinel and reduced data movement
 */
public class InsertionX {

    // sort input array using natural order
    public static void sort(Comparable[] input) {

        // move smallest element to the beginning to act as a sentinel
        int exchanges = 0;
        for (int i = input.length - 1; i > 0; i--) {
            if (input[i].compareTo(input[i-1]) < 0) {
                swap(input, i, i-1);
                exchanges++;
            }
        }

        if (exchanges == 0) {
            return;
        }

        // sort using half exchanges
        for (int i = 2; i < input.length; i++) {
            Comparable item = input[i];
            int j;
            for (j = i; item.compareTo(input[j-1]) < 0; j--) {
                input[j] = input[j-1];
            }
            input[j] = item;
        }
    }

    // swap input array items indexed by i and j
    private static void swap(Object[] input, int i, int j) {
        Object tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }

}
