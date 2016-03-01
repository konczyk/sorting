import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Compare algorithms average running time on random input
 */
public class Compare {

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

    private final Random RAND = new Random();

    private final int inputSize;
    private final int trials;
    private final int bound;
    private final boolean nonQuadratic;

    public Compare(int inputSize, int trials, int bound, boolean nonQuadratic) {
        this.inputSize = inputSize;
        this.trials = trials;
        this.bound = bound;
        this.nonQuadratic = nonQuadratic;
    }

    public void run() {
        String format = "%-12s %.4fs";
        for (String algorithm: ALGORITHMS) {
            if (!nonQuadratic || !isQuadratic(algorithm)) {
                double avgTime= time(algorithm);
                System.out.println(String.format(format, algorithm, avgTime));
            }
        }
    }

    private static boolean isQuadratic(String algorithm) {
        return QUADRATICS.contains(algorithm);
    }

    // compute average sorting time
    private double time(String algorithm) {
        double total = 0;
        for (int i = 0; i < trials; i++) {
            long start = System.currentTimeMillis();
            sort(algorithm, genRandomInput());

            long end = System.currentTimeMillis();
            total += ((end - start) / 1000.0);
        }

        return total / trials;
    }

    private Integer[] genRandomInput() {
        Integer[] input = new Integer[inputSize];
        for (int i = 0; i < inputSize; i++) {
            input[i] = 1 + RAND.nextInt(bound);
        }

        return input;
    }

    private void sort(String algorithm, Integer[] input) {
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

    public static void main(String[] args) {
        CompareConfig conf = CompareConfig.parseConfig(args);
        Compare compare = new Compare(conf.getInputSize(), conf.getTrials(),
                conf.getBound(), conf.isNonQuadratic());
        try {
            compare.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
