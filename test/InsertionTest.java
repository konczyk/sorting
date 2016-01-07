import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.*;

@RunWith(JUnitParamsRunner.class)
public class InsertionTest {

    @Test
    @Parameters(source = ComparableDataProvider.class)
    public void sortsUsingComparable(Comparable[] actual) {
        Insertion.sort(actual);
        assertThat(actual, is(ComparableDataProvider.EXPECTED));
    }

    @Test
    @Parameters(source = ComparableDuplicateDataProvider.class)
    public void sortsStableUsingComparable(Comparable[] actual) {
        Insertion.sort(actual);
        assertThat(actual, is(ComparableDuplicateDataProvider.EXPECTED));
    }

    @Test
    @Parameters(source = ComparatorDataProvider.class)
    public void sortsUsingComparator(Object[] actual) {
        Insertion.sort(actual, ComparatorDataProvider.COMPARATOR);
        assertThat(actual, is(ComparatorDataProvider.EXPECTED));
    }

}
