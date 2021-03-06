/**
 * Sorts an array using merge sort algorithm
 */
public class Merge {

    // sort input array using natural order
    // the tmp array will contain only T instances copied from input array
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void sort(T[] input) {
        T[] tmp = (T[]) new Comparable[input.length];
        sort(input, tmp, 0, input.length - 1);
    }

    private static <T extends Comparable<T>>
            void sort(T[] input, T[] tmp, int left, int right) {

        if (right <= left) {
            return;
        }

        int mid = (left + right) / 2;
        sort(input, tmp, left, mid);
        sort(input, tmp, mid+1, right);

        merge(input, tmp, left, mid, right);
    }

    private static <T extends Comparable<T>>
            void merge(T[] input, T[] tmp, int left, int mid, int right) {

        System.arraycopy(input, left, tmp, left, right - left + 1);

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

}
