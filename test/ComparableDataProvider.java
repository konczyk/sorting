public class ComparableDataProvider {

    public static final Comparable[] EXPECTED = {
        1, 4, 7, 9, 15, 17, 23, 34, 44, 46, 47, 77, 88, 91, 95, 95
    };

    public static Object[] provideArray() {
        return new Object[]{
            // reversed array
            new Integer[] {95,95,91,88,77,47,46,44,34,23,17,15,9,7,4,1},
            // shuffled array
            new Integer[] {17,77,7,34,47,1,91,88,46,95,23,9,15,44,4,95},
            // ordered array
            new Integer[] {1,4,7,9,15,17,23,34,44,46,47,77,88,91,95,95}
        };
    }

}
