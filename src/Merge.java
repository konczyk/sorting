/**
 * Sorts an array using merge sort algorithm
 */
public class Merge {

    // sort input array using natural order
    public static void sort(Comparable[] input) {
        Comparable[] tmp = input.clone();
        sort(input, tmp, 0, input.length - 1);
    }

    private static void sort(Comparable[] input, Comparable[] tmp,
                             int left, int right) {
        // base case
        if (right <= left)
            return;

        int mid = (left + right) / 2;
        // recursive calls
        sort(input, tmp, left, mid);
        sort(input, tmp, mid+1, right);
        // merge step
        merge(input, tmp, left, mid, right);
    }

    private static void merge(Comparable[] input, Comparable[] tmp,
                             int left, int mid, int right) {
        // copy items to be merged into tmp array
        for (int i = left; i <= right; i++)
            tmp[i] = input[i];

        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            // left half already merged in
            if (i > mid)
                input[k] = tmp[j++];
            // right part already merged in
            else if (j > right)
                input[k] = tmp[i++];
            else if (tmp[j].compareTo(tmp[i]) < 0)
                input[k] = tmp[j++];
            else
                input[k] = tmp[i++];
        }

    }

}
