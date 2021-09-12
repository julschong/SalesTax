import utils.InputParser;

import java.util.Scanner;


public class SalesTaxCalculator {

    public static final String INPUT_EXIT = "exit";
    public static final String INPUT_QUIT = "quit";
    public static final String INPUT_RESTART = "restart";
    public static final String INPUT_PRINT = "print";
    public static final String INPUT_MENU = "menu";
    public static final String INPUT_VIEW = "view";

    enum APP_STATE {STARTED, ENTER_AGAIN, EXIT}

    private Order currentOrder;
    private APP_STATE appState = APP_STATE.STARTED;

    public SalesTaxCalculator() {
        currentOrder = new Order();
    }


    public void start() {
        printMenu();
        while (!appState.equals(APP_STATE.EXIT)) {
            String input = getUserInput();
            inputActions(input);

            if (appState.equals(APP_STATE.STARTED)) {
                addItemToOrder(input);
            }
        }
        printExitMessage();
    }

    private String getUserInput() {
        System.out.printf("Please enter items or menu command:%n\t -- ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toLowerCase();
    }

    private void inputActions(String input) {
        switch (input) {
            case INPUT_EXIT:
            case INPUT_QUIT:
                appState = APP_STATE.EXIT;
                break;
            case INPUT_RESTART:
                restartOrder();
                appState = APP_STATE.ENTER_AGAIN;
                break;
            case INPUT_PRINT:
                if (currentOrder.printReceipt()) {
                    pauseBeforeRestart();
                    restartOrder();
                }
                appState = APP_STATE.ENTER_AGAIN;
                break;
            case INPUT_MENU:
                printMenu();
                appState = APP_STATE.ENTER_AGAIN;
                break;
            case INPUT_VIEW:
                currentOrder.viewCurrentOrder();
                appState = APP_STATE.ENTER_AGAIN;
                break;
            default:
                appState = APP_STATE.STARTED;
        }

    }

    private void printExitMessage() {
        System.out.println("Thank you for shopping at Julius' Store.\nHave a nice day!");
    }

    private void addItemToOrder(String input) {
        try {
            int quantity = InputParser.parseQTY(input);
            String itemName = InputParser.parseItemName(input);
            double linePrice = InputParser.parsePrice(input);
            LineItem item = new LineItem(quantity, itemName, linePrice);
            currentOrder.addItem(item);
            System.out.printf("** %d %s is added to cart, current subtotal is %.2f **%n%n"
                    , item.getQuantity(), item.getItemName(), currentOrder.getSubTotal());

        } catch (IllegalStateException e) {
            System.out.println("Invalid input format, format must be 'qty' 'item name' at 'price'");
        }
    }

    private void pauseBeforeRestart() {
        System.out.println("\nPress Enter key to continue.\n");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    private void restartOrder() {
        currentOrder = new Order();
        System.out.println("New Order:");
    }

    private static void printMenu() {
        System.out.println("Menu enter:");
        System.out.printf("\t%-13s%-2s%s%n", INPUT_EXIT + " or " + INPUT_QUIT, ":", "Exit from the application");
        System.out.printf("\t%-13s%-2s%s%n", INPUT_PRINT, ":", "Print receipt");
        System.out.printf("\t%-13s%-2s%s%n", INPUT_MENU, ":", "Bring up menu again");
        System.out.printf("\t%-13s%-2s%s%n", INPUT_RESTART, ":", "Clear the order");
        System.out.printf("\t%-13s%-2s%s%n", INPUT_VIEW, ":", "View current order");
        System.out.printf("*** %-13s%-2s%s ***%n", "Item Format", ":", "{Quantity} {Item Name} at {Unit Price}");
    }
}
