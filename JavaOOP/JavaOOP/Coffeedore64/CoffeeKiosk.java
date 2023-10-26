import java.util.ArrayList;

public class CoffeeKiosk {

    // MEMBER VARIABLES
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    // CONSTRUCTOR
    // Constructor - no params, initializes items and orders to empty arrays.
    public CoffeeKiosk() {
        this.menu = new ArrayList<Item>();
        this.orders = new ArrayList<Order>();
    }

    // OVERLOADED CONSTRUCTOR
    
    // METHODS
    public void addMenuItem(String name, double price) {
        // Create a new Item object with the given name and price
        Item newItem = new Item(name, price);
    
        // Add the new Item object to the menu items array
        menu.add(newItem);
    
        // Assign an index to the new menu item based on its position
        newItem.setIndex(menu.indexOf(newItem));
    }
    
    public void displayMenu() {
        for (int i = 0; i < menu.size(); i++) {
            Item item = menu.get(i);
            System.out.println(i + " " + item.getName() + " -- $" + item.getPrice());
        }
    }
    
    public void newOrder() {
    
        // Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
    
        // Create a new order with the given customer name
        Order newOrder = new Order(name);
    
        // Show the user the menu, so they can choose items to add
        displayMenu();
    
        // Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or 'q' to quit:");
        String itemNumber = System.console().readLine();
    
        // Write a while loop to collect all user's order items
        while (!itemNumber.equals("q")) {
            try {
                // Convert the user input to an integer
                int index = Integer.parseInt(itemNumber);
                
                // Check if the entered index is within the valid range
                if (index >= 0 && index < menu.size()) {
                    // Get the item object from the menu and add it to the order
                    Item chosenItem = menu.get(index);
                    newOrder.addItem(chosenItem);
                } else {
                    System.out.println("Invalid item index. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid item index or 'q' to quit.");
            }
    
            // Ask them to enter a new item index or 'q' again, and take their input
            System.out.println("Please enter a menu item index or 'q' to quit:");
            itemNumber = System.console().readLine();
        }
        
        // After you have collected their order, print the order details
        System.out.println("Order Details:");
        System.out.println("Customer Name: " + newOrder.getCustomerName());
        System.out.println("Items Ordered:");
        for (Item item : newOrder.getItems()) {
            System.out.println(item.getName() + " -- $" + item.getPrice());
        }
    }
    

    // GETTERS & SETTERS
    public ArrayList<Item> getMenu() {
        return this.menu;
    }

    public void setMenu(ArrayList<Item> menu) {
        this.menu = menu;
    }

    public ArrayList<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

}


// ! CODING DOJO VERSION:
import java.util.ArrayList;

public class CoffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    public CoffeeKiosk(){
        this.menu = new ArrayList<Item>();
        this.orders = new ArrayList<Order>();
    }

    public void addMenuItem(String name, double price){
        Item newItem = new Item(name, price);
        menu.add(newItem);
        newItem.setIndex(menu.indexOf(newItem));
    }

    public void displayMenu(){
        for(Item item : menu){
            System.out.println(item.getIndex()+" "+item.getName()+" -- $"+item.getPrice());
        }
    }

    public void newOrder() {
        
    	// Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
    
    	// Your code:
        // Create a new order with the given input string
        Order order = new Order(name);
        // Show the user the menu, so they can choose items to add.
        displayMenu();
        
    	// Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            
            // Get the item object from the menu, and add the item to the order
            try{
                order.addItem(menu.get(Integer.parseInt(itemNumber)));
            }catch(IndexOutOfBoundsException i){
                System.out.println("Invalid selection");
            }catch(NumberFormatException n){
                System.out.println("Invalid selection");
            }
            // Ask them to enter a new item index or q again, and take their input
            System.out.println("Please enter a menu item index or q to quit:");
            itemNumber = System.console().readLine();
        }
        // After you have collected their order, print the order details 
    	// as the example below. You may use the order's display method.
        order.display();
        
    }
}