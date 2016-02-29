import java.util.Comparator;
import java.util.Objects;

public class ComparatorDataProvider {

    public static final Comparator<Item> COMPARATOR = new Item.ByParam();

    public static final Object[] EXPECTED = {
        new Item(1), new Item(5), new Item(7), new Item(100), new Item(112)
    };

    public static Object[] provideArray() {
        return new Object[]{
            // reversed array
            new Item[] {new Item(112), new Item(100), new Item(7),
                        new Item(5), new Item(1)},
            // shuffled array
            new Item[] {new Item(5), new Item(1), new Item(100),
                        new Item(112), new Item(7)},
            // ordered array
            new Item[] {new Item(1), new Item(5), new Item(7),
                        new Item(100), new Item(112)},
        };
    }

    // test class
    public static class Item {

        private final int param;

        public Item(int p) {
            param = p;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Item item = (Item) o;

            return param == item.param;
        }

        @Override
        public int hashCode() {
            return Objects.hash(param);
        }

        @Override
        public String toString() {
            return Integer.toString(param);
        }

        public static class ByParam implements Comparator<Item> {

            public int compare(Item a, Item b) {
                return a.param - b.param;
            }

        }
    }
}
