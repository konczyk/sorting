/**
 * Sorts an array using bottom-up merge sort algorithm
 */
public class MergeB {

    // sort input array using natural order
    public static void sort(Comparable[] input) {
        int inputLength = input.length;
        Comparable[] tmp = new Comparable[inputLength];

        // first loop setting the step size, starting with 1-by-1 merge
        for (int step = 1; step < inputLength; step += step) {
            for (int left = 0; left < inputLength - step; left += 2 * step) {
                int mid = left + step - 1;
                // account for inputLength not being a power of 2
                int right = Math.min(left + 2 * step - 1, inputLength - 1);
                merge(input, tmp, left, mid, right);
            }
        }

    }

    private static void merge(Comparable[] input, Comparable[] tmp,
                             int left, int mid, int right) {
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
