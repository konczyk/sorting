import java.util.Arrays;
import java.util.Random;

/**
 * Compare algorithms average running time on random input
 */
public class Compare {

    private static final Random RAND = new Random();

    private static final String[] ALGORITHMS = {
        "Built-in",
        "Selection",
        "Insertion",
        "InsertionX",
    };

    private static void sort(String algorithm, Integer[] input) {
        if (algorithm.equals("Built-in"))
            Arrays.sort(input);
        else if (algorithm.equals("Selection"))
            Selection.sort(input);
        else if (algorithm.equals("Insertion"))
            Insertion.sort(input);
        else if (algorithm.equals("InsertionX"))
            InsertionX.sort(input);
    }

    // compute average sorting time
    private static double time(String algorithm, int size, int repeat) {
        double total = 0;
        for (int i = 0; i < repeat; i++) {
            // get random input array
            Integer[] input = genInput(size);

            // time one sort pass
            long start = System.currentTimeMillis();
            sort(algorithm, input);
            long end = System.currentTimeMillis();
            total += ((end - start) / 1000.0);
        }

        // return average time
        return total / repeat;
    }

    // generate Integer array with random input
    private static Integer[] genInput(int size) {
        Integer[] input = new Integer[size];
        for (int i = 0; i < size; i++) {
            input[i] = RAND.nextInt(size);
        }

        return input;
    }

    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        int repeat = Integer.parseInt(args[1]);

        for (String algorithm: ALGORITHMS) {
            double time = time(algorithm, size, repeat);
            System.out.println(algorithm + ":\t" +
                               String.format("%.4f", time) + "s");
        }
    }
}
