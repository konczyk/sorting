import java.util.Random;

/**
 * Sorts an array using quick sort algorithm with 3-way partitioning
 */
public class Quick3 {

    // sort input array using natural order
    public static <T extends Comparable<T>> void sort(T[] input) {
        shuffle(input);
        sort(input, 0, input.length - 1);
    }

    private static <T extends Comparable<T>>
            void sort(T[] input, int left, int right) {

        if (right <= left) {
            return;
        }

        T partitionItem = input[left];
        int curr = left + 1;
        int lt = left;
        int gt = right;
        while (curr <= gt) {
            int cmp = input[curr].compareTo(partitionItem);
            if (cmp < 0) {
                swap(input, lt, curr);
                lt++;
                curr++;
            } else if (cmp > 0) {
                swap(input, gt, curr);
                gt--;
            } else {
                curr++;
            }
        }

        sort(input, left, lt - 1);
        sort(input, gt + 1, right);
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
