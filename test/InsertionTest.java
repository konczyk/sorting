import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.*;

@RunWith(JUnitParamsRunner.class)
public class InsertionTest {

    @Test
    @Parameters(source = ComparableDataProvider.class)
    public <T extends Comparable<T>> void sortComparables(T[] actual) {
        Insertion.sort(actual);
        assertThat(actual, is(ComparableDataProvider.EXPECTED));
    }

    @Test
    @Parameters(source = ComparableDuplicateDataProvider.class)
    public <T extends Comparable<T>> void sortComparablesIsStable(T[] actual) {
        Insertion.sort(actual);
        assertThat(actual, is(ComparableDuplicateDataProvider.EXPECTED));
    }

    @Test
    @Parameters(source = ComparatorDataProvider.class)
    public void sortUsingComparator(ComparatorDataProvider.Item[] actual) {
        Insertion.sort(actual, ComparatorDataProvider.COMPARATOR);
        assertThat(actual, is(ComparatorDataProvider.EXPECTED));
    }

}
