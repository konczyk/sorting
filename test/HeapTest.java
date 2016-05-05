import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class HeapTest {

    @Test
    @Parameters(source = ComparableDataProvider.class)
    public <T extends Comparable<T>> void sortComparables(T[] actual) {
        Heap.sort(actual);
        assertThat(actual, is(ComparableDataProvider.EXPECTED));
    }

    @Test
    @Parameters(source = ComparableDuplicateDataProvider.class)
    public <T extends Comparable<T>> void sortComparablesIsUnstable(T[] actual) {
        Heap.sort(actual);
        assertThat(actual, is(not(ComparableDuplicateDataProvider.EXPECTED)));
    }

}
