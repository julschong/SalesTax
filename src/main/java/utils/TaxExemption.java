package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class TaxExemption {
    private static TaxExemption taxExemption;
    private String taxExemptionRegex;

    private TaxExemption() {
    }

    public static TaxExemption getInstance() throws IOException {
        if (taxExemption == null) {
            taxExemption = new TaxExemption();
            taxExemption.loadExemptions();
        }
        return taxExemption;
    }

    public String getTaxExemptionRegex() {
        return taxExemptionRegex;
    }

    private void loadExemptions() throws IOException {
        String fileName = "/taxExemptions.txt";

        InputStream inputStream = getClass().getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new FileNotFoundException("Cannot find file:" + fileName);
        }

        //Read File Content
        Scanner scanner = new Scanner(inputStream);
        StringBuilder stringBuilder = new StringBuilder();

        while (scanner.hasNext()) {
            String item = scanner.nextLine();
            stringBuilder.append(item).append("|");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        taxExemptionRegex = stringBuilder.toString();
    }
}
