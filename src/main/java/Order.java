import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<LineItem> cart;
    private double totalSalesTax = 0;
    private double total = 0;
    private double subTotal = 0;

    public Order() {
        cart = new ArrayList<>();
    }

    public void addItem(LineItem itemToAdd) {
        cart.add(itemToAdd);
        totalSalesTax += itemToAdd.getSalesTax();
        total += itemToAdd.getQuantity() * itemToAdd.getUnitPrice() + itemToAdd.getSalesTax();
        subTotal += itemToAdd.getQuantity() * itemToAdd.getUnitPrice();
    }

    public void viewCurrentOrder() {
        if (cart.size() == 0) {
            System.out.println("There is no item in the cart!");
        }

        System.out.println("Current Order:");
        cart.forEach(item -> System.out.println("\t" + item.toString()));
    }

    public boolean printReceipt() {

        if (cart.size() == 0) {
            System.out.println("There is no item in the cart!");
            return false;
        }

        System.out.println();
        cart.forEach(item -> System.out.println(item.toString()));
        System.out.printf("Sales Taxes: %.2f%n", totalSalesTax);
        System.out.printf("Total: %.2f%n", total);
        return true;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public static void main(String[] args) {
        Order cart = new Order();
        LineItem item1 = new LineItem(1, "book", 12.49);
        LineItem item2 = new LineItem(1, "music CD", 14.99);
        LineItem item3 = new LineItem(1, "chocolate bar", 0.85);

        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        cart.printReceipt();
    }
}
