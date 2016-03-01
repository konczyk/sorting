import java.util.Random;

/**
 * Sorts an array using quick sort algorithm
 */
public class Quick {

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

        int partitionIndex = partition(input, left, right);
        sort(input, left, partitionIndex - 1);
        sort(input, partitionIndex + 1, right);
    }

    private static <T extends Comparable<T>>
            int partition(T[] input, int left, int right) {

        T partitionItem = input[left];
        int i = left;
        int j = right + 1;
        while (true) {
            // left scan for the item to swap
            while (input[++i].compareTo(partitionItem) < 0) {
                if (i == right) {
                    break;
                }
            }
            // right scan for the item to swap
            while (input[--j].compareTo(partitionItem) > 0) {
                if (j == left) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            swap(input, i, j);
        }

        // put the partition item in place
        swap(input, left, j);

        return j;

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
