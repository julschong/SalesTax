import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class OrderTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private Order order;

    @BeforeEach
    public void setUp() {
        order = new Order();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void addItem() {
        order.addItem(new LineItem(1, "book", 6.5));
        assertEquals(order.getSubTotal(), 6.50, 0.00001);
    }

    @Test
    public void viewCurrentOrder() {
        order.viewCurrentOrder();
        assertEquals("There is no item in the cart!", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();
        LineItem item = new LineItem(1, "book", 12);
        order.addItem(item);
        order.viewCurrentOrder();

        String expected = "Current Order:\n\t1 book: 12.00"
                .replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
        assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    @Test
    public void printReceipt() {
        order.printReceipt();
        assertEquals("There is no item in the cart!", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset();
        LineItem item = new LineItem(1, "book", 12);
        order.addItem(item);
        order.printReceipt();

        String expected = "1 book: 12.00\r\nSales Taxes: 0.00\r\nTotal: 12.00"
                .replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
        assertEquals(expected, outputStreamCaptor.toString().trim());
    }
}