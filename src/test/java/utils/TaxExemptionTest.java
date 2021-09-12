package utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TaxExemptionTest {

    private final TaxExemption taxExemption = TaxExemption.getInstance();

    TaxExemptionTest() throws IOException {
    }

    @BeforeEach

    @Test
    void getTaxExemptionRegex() {
        String actual = taxExemption.getTaxExemptionRegex();
        assertTrue(actual.contains("book") && actual.contains("pill") && actual.contains("chocolate"));
    }
}