public class LineItem {
    private final int quantity;
    private final String itemName;
    private final double unitPrice;
    private int salesTaxRateInPercent = 10; // Sales Tax of 10% = 10

    /**
     * @param quantity
     * @param itemName
     * @param unitPrice
     */
    public LineItem(int quantity, String itemName, double unitPrice) {
        this.quantity = quantity;
        this.itemName = itemName;
        this.unitPrice = unitPrice;

        if (itemName.contains("imported")) {
            this.salesTaxRateInPercent += 5;
        }

        if (itemName.matches(".*(book|chocolate|pills).*")) {
            this.salesTaxRateInPercent -= 10;
        }

    }

    @Override
    public String toString() {
        return String.format("%d %s: %.2f", quantity, itemName, (quantity * unitPrice + getSalesTax()));
    }

    public double getSalesTax() {
        return Math.ceil(quantity * unitPrice * salesTaxRateInPercent / 100 * 20) / 20d;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public static void main(String[] args) {
        LineItem item1 = new LineItem(1, "book", 12.49);
        LineItem item2 = new LineItem(1, "music CD", 14.99);
        LineItem item3 = new LineItem(1, "chocolate bar", 0.85);
        System.out.println(item1);
        System.out.println(item2);
        System.out.println(item3);
        System.out.println(item1.getSalesTax() + item2.getSalesTax() + item3.getSalesTax());
    }
}
