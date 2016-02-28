import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.*;

@RunWith(JUnitParamsRunner.class)
public class SelectionTest {

    @Test
    @Parameters(source = ComparableDataProvider.class)
    public <T extends Comparable<T>> void sortComparables(T[] actual) {
        Selection.sort(actual);
        assertThat(actual, is(ComparableDataProvider.EXPECTED));
    }

    @Test
    @Parameters(source = ComparableDuplicateDataProvider.class)
    public <T extends Comparable<T>> void sortComparablesIsUnstable(T[] actual) {
        Selection.sort(actual);
        assertThat(actual, is(not(ComparableDuplicateDataProvider.EXPECTED)));
    }

    @Test
    @Parameters(source = ComparatorDataProvider.class)
    public void sortUsingComparator(ComparatorDataProvider.Item[] actual) {
        Selection.sort(actual, ComparatorDataProvider.COMPARATOR);
        assertThat(actual, is(ComparatorDataProvider.EXPECTED));
    }
}
