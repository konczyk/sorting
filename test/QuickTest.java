import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.*;

@RunWith(JUnitParamsRunner.class)
public class QuickTest {

    @Test
    @Parameters(source = ComparableDataProvider.class)
    public <T extends Comparable<T>> void sortComparables(T[] actual) {
        Quick.sort(actual);
        assertThat(actual, is(ComparableDataProvider.EXPECTED));
    }

}
