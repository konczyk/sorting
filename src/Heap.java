/**
 * Sorts an array using heap sort algorithm
 */
public class Heap {

    // sort input array using natural order
    public static <T extends Comparable<T>> void sort(T[] input) {

        int n = input.length;
        // construct the heap
        for (int k = n/2; k >= 1; k--) {
            heapify(input, k, n);
        }
        // sort down
        while (n > 1) {
            swap(input, 0, --n);
            heapify(input, 1, n);
        }
    }

    private static <T extends Comparable<T>> void heapify(
            T[] input, int k, int n) {
        while (2*k <= n) {
            int j = 2*k;
            // select bigger child
            if (j < n && input[j-1].compareTo(input[j]) < 0) {
                j++;
            }
            // exchange bigger child with the parent, if needed
            if (input[k-1].compareTo(input[j-1]) >= 0) {
                break;
            }
            swap(input, k-1, j-1);
            k = j;
        }
    }

    // swap input array items indexed by i and j
    private static void swap(Object[] input, int i, int j) {
        Object tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }
}
