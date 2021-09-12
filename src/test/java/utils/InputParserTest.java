package utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    @Test
    void parseQTY() {
        int actual = InputParser.parseQTY("1 car at 12");
        assertEquals(1, actual);

        actual = InputParser.parseQTY("100 car at 12.00");
        assertEquals(100, actual);

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            InputParser.parseQTY(" car at 1");
        });

        String expectedMessage = "No match found";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    void parseItemName() {
        String actual = InputParser.parseItemName("1 car at 12");
        assertEquals("car", actual);

        actual = InputParser.parseItemName("100 car bike cake at 12.00");
        assertEquals("car bike cake", actual);

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            InputParser.parseItemName("car at 1");
        });

        String expectedMessage = "No match found";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void parsePrice() {
        double actual = InputParser.parsePrice("1 car at 12");
        assertEquals(12d, actual);

        actual = InputParser.parsePrice("100 car bike cake at 12.00");
        assertEquals(12d, actual);

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            InputParser.parseItemName("car at one dollar");
        });

        String expectedMessage = "No match found";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}