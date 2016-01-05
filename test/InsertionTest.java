import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.*;

@RunWith(JUnitParamsRunner.class)
public class InsertionTest {

    @Test
    @Parameters(source = ComparableDataProvider.class)
    public void sortsUsingComparable(Comparable[] input) {
        Insertion.sort(input);
        assertArrayEquals(ComparableDataProvider.EXPECTED, input);
    }

    @Test
    @Parameters(source = ComparatorDataProvider.class)
    public void sortsUsingComparator(Object[] input) {
        Insertion.sort(input, ComparatorDataProvider.COMPARATOR);
        assertArrayEquals(ComparatorDataProvider.EXPECTED, input);
    }

    @Test
    @Parameters(source = ComparableDuplicateDataProvider.class)
    public void sortsStableUsingComparator(Comparable[] input) {
        Insertion.sort(input);
        assertArrayEquals(ComparableDuplicateDataProvider.EXPECTED, input);
    }
}
