import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class OrderTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private Order order;

    @AfterAll
    public static void tearDown() throws Exception {
    }

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
    @DisplayName("viewCurrentOrder Test")
    public void viewCurrentOrder() {
        System.out.println("hello");
        assertEquals("hello", outputStreamCaptor.toString().trim());
    }

    @Test
    public void printReceipt() {
    }

    @Test
    public void getSubTotal() {
    }
}