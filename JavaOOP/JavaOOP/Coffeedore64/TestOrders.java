public class TestOrders {
    public static void main(String[] args) {
        // Create a CoffeeKiosk instance
        CoffeeKiosk kiosk = new CoffeeKiosk();

        // Add menu items to the CoffeeKiosk
        kiosk.addMenuItem("drip coffee", 2.22);
        kiosk.addMenuItem("capuccino", 3.48);
        kiosk.addMenuItem("latte", 2.73);
        kiosk.addMenuItem("mocha", 1.76);

        // Display the menu
        kiosk.displayMenu();

        // Create a new order using user input
        kiosk.newOrder();
    }
}
