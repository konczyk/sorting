import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.*;

@RunWith(JUnitParamsRunner.class)
public class SelectionTest {

    @Test
    @Parameters(source = ComparableDataProvider.class)
    public void sortsUsingComparable(Comparable[] actual) {
        Selection.sort(actual);
        assertThat(actual, is(ComparableDataProvider.EXPECTED));
    }

    @Test
    @Parameters(source = ComparableDuplicateDataProvider.class)
    public void sortsUnstableUsingComparable(Comparable[] actual) {
        Selection.sort(actual);
        assertThat(actual, is(not(ComparableDuplicateDataProvider.EXPECTED)));
    }

    @Test
    @Parameters(source = ComparatorDataProvider.class)
    public void sortsUsingComparator(Object[] actual) {
        Selection.sort(actual, ComparatorDataProvider.COMPARATOR);
        assertThat(actual, is(ComparatorDataProvider.EXPECTED));
    }
}
