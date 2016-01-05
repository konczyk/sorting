import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertArrayEquals;

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
}
