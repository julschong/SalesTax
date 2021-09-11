package utils;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
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
        String fileName = "taxExemptions.txt";
        ClassLoader classLoader = TaxExemption.class.getClassLoader();

        File file = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());

        //Read File Content
        Scanner scanner = new Scanner(file);
        StringBuilder stringBuilder = new StringBuilder();

        while (scanner.hasNext()) {
            String item = scanner.nextLine();
            stringBuilder.append(item).append("|");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        taxExemptionRegex = stringBuilder.toString();
    }
}
