import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.*;

@RunWith(JUnitParamsRunner.class)
public class MergeTest {

    @Test
    @Parameters(source = ComparableDataProvider.class)
    public void sortsUsingComparable(Comparable[] actual) {
        Merge.sort(actual);
        assertThat(actual, is(ComparableDataProvider.EXPECTED));
    }

    @Test
    @Parameters(source = ComparableDuplicateDataProvider.class)
    public void sortsStableUsingComparable(Comparable[] actual) {
        Merge.sort(actual);
        assertThat(actual, is(ComparableDuplicateDataProvider.EXPECTED));
    }

}
