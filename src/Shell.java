/**
 * Sorts an array using shell sort algorithm with
 * Knuth's increment sequence 3x+1
 */
public class Shell {

    // sort input array using natural order
    public static void sort(Comparable[] input) {

        int size = input.length;

        // find the biggest h
        int h = 1;
        while (h < size/3) {
            h = 3*h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < size; i++) {
                for (int j = i; j >= h && input[j].compareTo(input[j-h]) < 0; j -= h) {
                    swap(input, j, j-h);
                }
            }

            h /= 3;
        }
    }

    // swap input array items indexed by i and j
    private static void swap(Object[] input, int i, int j) {
        Object tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }
}
