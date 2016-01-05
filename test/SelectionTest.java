import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.*;

@RunWith(JUnitParamsRunner.class)
public class SelectionTest {

    @Test
    @Parameters(source = ComparableDataProvider.class)
    public void sortsUsingComparable(Comparable[] input) {
        Selection.sort(input);
        assertArrayEquals(ComparableDataProvider.EXPECTED, input);
    }

    @Test
    @Parameters(source = ComparatorDataProvider.class)
    public void sortsUsingComparator(Object[] input) {
        Selection.sort(input, ComparatorDataProvider.COMPARATOR);
        assertArrayEquals(ComparatorDataProvider.EXPECTED, input);
    }
}
