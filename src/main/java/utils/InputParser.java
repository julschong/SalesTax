package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {
    public static int parseQTY(String input) {
        Pattern quantityPat = Pattern.compile("^\\d+");
        Matcher quantityMat = quantityPat.matcher(input);
        quantityMat.find();
        return Integer.parseInt(quantityMat.group(0));
    }

    public static String parseItemName(String input) {
        Pattern itemNamePat = Pattern.compile("\\d ([\\w\\s]+) at");
        Matcher itemNameMat = itemNamePat.matcher(input);
        itemNameMat.find();
        String parsed = itemNameMat.group(1).trim().replaceAll(" \\s+", " ");
        return parsed;
    }

    public static double parsePrice(String input) {
        Pattern pricePat = Pattern.compile("\\d+$|\\d+.\\d+$");
        Matcher priceMat = pricePat.matcher(input);
        priceMat.find();
        return Double.parseDouble(priceMat.group(0));
    }
}
