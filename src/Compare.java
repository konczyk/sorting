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
        "MergeB",
        "Quick",
        "QuickX",
        "Quick3");

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
            input[i] = 1 + RAND.nextInt(inputSize);
        }

        return input;
    }

    private static boolean isQuadratic(String algorithm) {
        return QUADRATICS.contains(algorithm);
    }

    private static void run(int inputSize, int trials, boolean nonQuadtratic) {
        String format = "%-12s %.4fs";
        for (String algorithm: ALGORITHMS) {
            if (!nonQuadtratic || !isQuadratic(algorithm)) {
                double time = time(algorithm, inputSize, trials);
                System.out.println(String.format(format, algorithm, time));
            }
        }
    }

    public static void main(String[] args) {
        CompareConfig conf = CompareConfig.parseConfig(args);
        try {
            run(conf.getInputSize(), conf.getTrials(), conf.isNonQuadratic());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
