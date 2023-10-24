public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app.
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "your total is $";

        // Menu variables (add yours below)
        double mochaPrice = 3.50;
        double dripCoffee = 6.00;
        double latte = 4.00;
        double cappuccino = 5.00;

        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"

        // ** Your customer interaction print statements will go here ** //

        System.out.println(customer1 + pendingMessage);
        // Displays "Cindhuri, your order will be ready shortly"

        System.out.println(isReadyOrder1 ? customer4 + readyMessage : customer4 + pendingMessage);
        // Displays "Noah, your order will be ready shortly" because the default boolean
        // is set to false

        // ! Alternate way Nathan and Fernanda showed me to do the total, creating a new variable
        int numberOfLattes = 2;
        double total = numberOfLattes * latte;

        System.out.println(isReadyOrder1 ? customer2 + readyMessage + " and " + displayTotalMessage + (latte + latte)
                : customer2 + pendingMessage + " and " + displayTotalMessage + total);
        // Displays "Sam, your order is ready and your total is $8.0" because the
        // default booleanis set to true
        // OR
        // Displays "Sam, your order will be ready shortly and your total is $8.0"
        // because the default boolean is set to false

        System.out.println(customer3 + " owes $" + (dripCoffee - latte));
        // Displays "Jimmy, owes $2.0"
    }
}
