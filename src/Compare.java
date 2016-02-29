import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Compare algorithms average running time on random input
 */
public class Compare {

    private static final Random RAND = new Random();

    private static final List<String> ALGORITHMS = Arrays.asList(
        "Built-in",
        "Selection",
        "Insertion",
        "InsertionX",
        "Shell",
        "Merge",
        "MergeX",
        "MergeB");

    private static final List<String> QUADRATICS = Arrays.asList(
        "Selection",
        "Insertion",
        "InsertionX");

    private static void sort(String algorithm, Integer[] input) {
        if (algorithm.equals("Built-in")) {
            Arrays.sort(input);
        } else {
            try {
                Class<?> c = Class.forName(algorithm);
                Method m = c.getMethod("sort", Comparable[].class);
                m.invoke(null, new Object[]{input});
            } catch (ReflectiveOperationException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    // compute average sorting time
    private static double time(String algorithm, int inputSize, int trials) {
        double total = 0;
        for (int i = 0; i < trials; i++) {
            long start = System.currentTimeMillis();
            sort(algorithm, genRandomInput(inputSize));

            long end = System.currentTimeMillis();
            total += ((end - start) / 1000.0);
        }

        return total / trials;
    }

    private static Integer[] genRandomInput(int inputSize) {
        Integer[] input = new Integer[inputSize];
        for (int i = 0; i < inputSize; i++) {
            input[i] = RAND.nextInt(inputSize);
        }

        return input;
    }

    private static boolean isQuadratic(String algorithm) {
        return QUADRATICS.contains(algorithm);
    }

    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        int repeat = Integer.parseInt(args[1]);
        boolean noquadratic = false;
        if (args.length == 3 && args[2].equals("noquad")) {
            noquadratic = true;
        }

        try {
            for (String algorithm: ALGORITHMS) {
                if (!noquadratic || !isQuadratic(algorithm)) {
                    double time = time(algorithm, size, repeat);
                    System.out.println(String.format("%-12s %.4fs", algorithm, time));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
