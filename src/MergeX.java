/**
 * Sorts an array using merge sort algorithm
 */
public class MergeX {

    private static final int INSERTION_THRESHOLD = 10;

    // sort input array using natural order
    public static <T extends Comparable<T>> void sort(T[] input) {
        T[] tmp = input.clone();
        sort(input, tmp, 0, input.length - 1);
    }

    private static <T extends Comparable<T>>
            void sort(T[] input, T[] tmp, int left, int right) {

        if (right - left + 1 <= INSERTION_THRESHOLD) {
            insertionSort(input, left, right);
        } else {
            int mid = left + (right - left) / 2;
            // recursive calls with swapped input and tmp
            // this way we don't need to copy from input to tmp before merge
            sort(tmp, input, left, mid);
            sort(tmp, input, mid+1, right);

            // check if arrays are already in sorted order and skip the merge
            if (tmp[mid].compareTo(tmp[mid+1]) < 0) {
                System.arraycopy(tmp, left, input, left, right - left + 1);
            } else {
                merge(input, tmp, left, mid, right);
            }
        }
    }

    private static <T extends Comparable<T>>
            void merge(T[] input, T[] tmp, int left, int mid, int right) {

        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                input[k] = tmp[j++];
            } else if (j > right) {
                input[k] = tmp[i++];
            } else if (tmp[j].compareTo(tmp[i]) < 0) {
                input[k] = tmp[j++];
            } else {
                input[k] = tmp[i++];
            }
        }
    }

    private static <T extends Comparable<T>>
            void insertionSort(T[] input, int left, int right) {

        for (int i = left; i <= right; i++) {
            for (int j = i; j > left && input[j].compareTo(input[j-1]) < 0; j--) {
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
