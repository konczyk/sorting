public class ComparableDuplicateDataProvider {

    public static final Comparable[] EXPECTED = {
        new Item("A", 2), new Item("A", 3), new Item("B", 1),
        new Item("C", 2), new Item("D", 1), new Item("D", 2)
    };

    public static Object[] provideArray() {
        return new Object[]{
            new Item[]{
                new Item("A", 2), new Item("D", 1), new Item("B", 1),
                new Item("C", 2), new Item("D", 2), new Item("A", 3)
            },
        };
    }

    // test class
    private static class Item implements Comparable<Item> {

        private final String param1;
        private final int param2;

        public Item(String p1, int p2) {
            param1 = p1;
            param2 = p2;
        }

        @Override
        public boolean equals(Object other) {
            return this.param1.equals(((Item) other).param1) &&
                   this.param2 == ((Item) other).param2;
        }

        @Override
        public String toString() {
            return param1 + Integer.toString(param2);
        }

        @Override
        public int compareTo(Item other) {
            return this.param1.compareTo(other.param1);
        }

    }
}
