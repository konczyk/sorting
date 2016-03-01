import java.util.Random;

/**
 * Sorts an array using improved quick sort algorithm
 */
public class QuickX {

    private static final int INSERTION_THRESHOLD = 10;
    private static final int MEDIAN3_THRESHOLD = 40;

    // sort input array using natural order
    public static <T extends Comparable<T>> void sort(T[] input) {
        sort(input, 0, input.length - 1);
    }

    private static <T extends Comparable<T>>
            void sort(T[] input, int left, int right) {

        int elems = right - left + 1;

        if (elems <= INSERTION_THRESHOLD) {
            insertionSort(input, left, right);
        } else {
            int partitionIndex;
            // median-of-3 partitioning element
            if (elems <= MEDIAN3_THRESHOLD) {
                partitionIndex = median3(input, left, (left+right)/2, right);
            }
            // Tukey's ninther partitioning element
            else {
                partitionIndex = ninther(input, left, right);
            }
            swap(input, left, partitionIndex);

            // fast 3-way partitioning (Bentley-McIlroy)
            T partitionItem = input[left];
            int i = left + 1;
            int j = right;
            int p = left + 1;
            int q = right;
            while (true) {
                // left scan for the item to swap
                while (input[i].compareTo(partitionItem) < 0) {
                    if (i == right) {
                        break;
                    }
                    i++;
                }
                // right scan for the item to swap
                while (input[j].compareTo(partitionItem) > 0) {
                    if (j == left) {
                        break;
                    }
                    j--;
                }

                // put equal item in place when scan indices cross
                if (i == j && input[i].compareTo(partitionItem) == 0) {
                    swap(input, p++, i);
                }

                if (i >= j) {
                    break;
                }

                swap(input, i, j);
                // put equal items in place
                if (input[i].compareTo(partitionItem) == 0) {
                    swap(input, p++, i);
                }
                if (input[j].compareTo(partitionItem) == 0) {
                    swap(input, q--, j);
                }
            }

            // re-swap to maintain the original quick sort invariant
            for (int k = left; k < p; k++) {
                swap(input, k, j--);
            }
            for (int k = right; k > q; k--) {
                swap(input, k, i++);
            }

            sort(input, left, j);
            sort(input, i, right);
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

    // return the index of the median of medians element
    private static <T extends Comparable<T>>
            int ninther(T[] input, int left, int right) {

        int delta = (right - left + 1) / 8;
        int mid = (left + right) / 2;
        int med1 = median3(input, left, left + delta, left + 2*delta);
        int med2 = median3(input, mid - delta, mid, mid + delta);
        int med3 = median3(input, right - 2*delta, right - delta, right);

        return median3(input, med1, med2, med3);
    }

    // return the index of the median-of-3 element
    private static <T extends Comparable<T>>
            int median3(T[] input, int i, int j, int k) {

        if (input[i].compareTo(input[j]) < 0) {
            if (input[j].compareTo(input[k]) < 0) {
                return j;
            } else if (input[i].compareTo(input[k]) < 0) {
                return k;
            }
        } else {
            if (input[k].compareTo(input[j]) < 0) {
                return j;
            } else if (input[k].compareTo(input[i]) < 0) {
                return k;
            }
        }

        return i;
    }

    // shuffle array elements in uniformly random order
    private static void shuffle(Object[] input) {
        Random rand = new Random();
        for (int i = 0; i < input.length; i++) {
            int idx = i + rand.nextInt(input.length - i);
            Object temp = input[i];
            input[i] = input[idx];
            input[idx] = temp;
        }
    }

    // swap input array items indexed by i and j
    private static void swap(Object[] input, int i, int j) {
        Object tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }

}
