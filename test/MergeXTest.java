import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.*;

@RunWith(JUnitParamsRunner.class)
public class MergeXTest {

    @Test
    @Parameters(source = ComparableDataProvider.class)
    public <T extends Comparable<T>> void sortComparables(T[] actual) {
        MergeX.sort(actual);
        assertThat(actual, is(ComparableDataProvider.EXPECTED));
    }

    @Test
    @Parameters(source = ComparableDuplicateDataProvider.class)
    public <T extends Comparable<T>> void sortComparablesIsStable(T[] actual) {
        MergeX.sort(actual);
        assertThat(actual, is(ComparableDuplicateDataProvider.EXPECTED));
    }

}
