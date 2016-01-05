import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.*;

@RunWith(JUnitParamsRunner.class)
public class InsertionXTest {

    @Test
    @Parameters(source = ComparableDataProvider.class)
    public void sortsUsingComparable(Comparable[] input) {
        InsertionX.sort(input);
        assertArrayEquals(ComparableDataProvider.EXPECTED, input);
    }

    @Test
    @Parameters(source = ComparableDuplicateDataProvider.class)
    public void sortsStableUsingComparable(Comparable[] input) {
        InsertionX.sort(input);
        assertArrayEquals(ComparableDuplicateDataProvider.EXPECTED, input);
    }
}
