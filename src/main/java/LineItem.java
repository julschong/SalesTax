public class LineItem {
    private final int quantity;
    private final String itemName;
    private final double unitPrice;
    private boolean imported = false;

    public LineItem(int quantity, String itemName, double unitPrice) {
        this.quantity = quantity;
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        if (itemName.contains("imported")) {
            this.imported = true;
        }
    }

    @Override
    public String toString() {
        return quantity + " " + itemName + ": " + quantity * unitPrice;
    }

    public static void main(String[] args) {
        LineItem item1 = new LineItem(1, "imported book", 12.49);
        LineItem item2 = new LineItem(1, "music CD", 14.99);
        LineItem item3 = new LineItem(1, "chocolate bar", 0.85);
        System.out.println(item1);
        System.out.println(item2);
        System.out.println(item3);
    }
}
