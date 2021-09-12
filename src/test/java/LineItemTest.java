import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LineItemTest {

    LineItem item1;

    @Test
    void getSalesTax() {
        item1 = new LineItem(1, "book", 12);
        assertEquals(0, item1.getSalesTax());

        item1 = new LineItem(1, "pill", 12);
        assertEquals(0, item1.getSalesTax());

        item1 = new LineItem(1, "chocolate", 12);
        assertEquals(0, item1.getSalesTax());

        item1 = new LineItem(1, "imported chocolate", 12);
        assertEquals(0.6, item1.getSalesTax());

        item1 = new LineItem(3, "imported coke", 12);
        assertEquals(5.4, item1.getSalesTax());
    }
}