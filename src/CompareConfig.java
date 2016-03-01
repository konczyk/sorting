import com.beust.jcommander.*;

public class CompareConfig {

    @Parameter(
        names = {"--input-size", "-i"},
        description = "Input size",
        validateWith = PositiveIntegerValidator.class,
        required = true)
    private int inputSize = 0;

    @Parameter(
        names = {"--trials", "-t"},
        description = "Number of trials",
        validateWith = PositiveIntegerValidator.class,
        required = true)
    private int trials = 0;

    @Parameter(
        names = {"--non-quadratic", "-nq"},
        description = "Compare algorithms with non-quadratic running time only")
    private boolean nonQuadtratic = false;

    @Parameter(
        names = {"--help", "-h"},
        description = "Help",
        help = true)
    private boolean help = false;

    public int getInputSize() {
        return inputSize;
    }

    public int getTrials() {
        return trials;
    }

    public boolean isNonQuadratic() {
        return nonQuadtratic;
    }

    public static CompareConfig parseConfig(String args[]) {
        CompareConfig config = new CompareConfig();
        if (args.length == 0) {
            new JCommander(config).usage();
            System.exit(0);
        }

        JCommander jc = new JCommander(config);
        try {
            jc.parse(args);
            if (config.help) {
                jc.usage();
                System.exit(0);
            }
        } catch (ParameterException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        return config;
    }

    public static class PositiveIntegerValidator
            implements IParameterValidator {

        @Override
        public void validate(String name, String value)
                throws ParameterException {

            String msg = "\"" + name + "\": should be a positive integer, " +
                         "\"" + value + "\" given";

            try {
                int n = Integer.parseInt(value);
                if (n <= 0) {
                    throw new ParameterException(msg);
                }
            } catch (Exception e) {
                throw new ParameterException(msg);
            }
        }
    }

}