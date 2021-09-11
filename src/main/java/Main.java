import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Order order = new Order();
        Scanner scanner = new Scanner(System.in);

        String input;

        printMenu();
        do {
            System.out.printf("Please enter items or menu command:%n\t -- ");
            input = scanner.nextLine();


            if (input.equals("exit") || input.equals("quit")) {
                break;
            }

            if (input.equals("restart")) {
                order = new Order();
                System.out.println("New Order:");
                continue;
            }

            if (input.equals("print")) {
                order.printReceipt();
                order = new Order();
                System.out.println("\nPress any key to continue.\n");
                input = scanner.nextLine();

                System.out.println("New Order:");

                continue;
            }

            if (input.equals("menu")) {
                printMenu();
                continue;
            }

            if (input.equals("view")) {
                order.viewCurrentOrder();
                continue;
            }


            try {
                int quantity = parseQTY(input);
                String itemName = parseItemName(input);
                double linePrice = parsePrice(input);

                LineItem item = new LineItem(quantity, itemName, linePrice);
                order.addItem(item);
                System.out.printf("** %d %s is added to cart, current subtotal is %.2f **%n%n"
                        , quantity, itemName, order.getSubTotal());
                
            } catch (IllegalStateException e) {
                System.out.println("Invalid input format, format must be 'qty' 'item name' at 'price'");
            }


        } while (true);

        System.out.println("Thank you for shopping at Julius Store, have a nice day!");
        System.exit(0);

    }

    private static int parseQTY(String input) {
        Pattern quantityPat = Pattern.compile("^\\d+");
        Matcher quantityMat = quantityPat.matcher(input);
        quantityMat.find();
        return Integer.parseInt(quantityMat.group(0));
    }

    private static String parseItemName(String input) {
        Pattern itemNamePat = Pattern.compile("\\d ([\\w\\s]+) at");
        Matcher itemNameMat = itemNamePat.matcher(input);
        itemNameMat.find();
        return itemNameMat.group(1);
    }

    private static double parsePrice(String input) {
        Pattern pricePat = Pattern.compile("\\d+[.]?\\d+$");
        Matcher priceMat = pricePat.matcher(input);
        priceMat.find();
        return Double.parseDouble(priceMat.group(0));
    }

    private static void printMenu() {
        System.out.println("Menu enter:");
        System.out.printf("\t%-17s%-2s%s%n", "'exit' or 'quit'", ":", "Exit from the application");
        System.out.printf("\t%-17s%-2s%s%n", "'print'", ":", "Print receipt");
        System.out.printf("\t%-17s%-2s%s%n", "'menu'", ":", "Bring up menu again");
        System.out.printf("\t%-17s%-2s%s%n", "'restart'", ":", "Clear the order");
        System.out.printf("\t%-17s%-2s%s%n", "'view'", ":", "View current order");
        System.out.printf("*** %-17s%-2s%s ***%n", "Item Format", ":", "{Quantity} {Item Name} at {Unit Price}");
    }

}
