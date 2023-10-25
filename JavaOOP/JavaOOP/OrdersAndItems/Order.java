import java.util.ArrayList;
// Here we're creating a new data type called order

public class Order {

    // MEMBER VARIABLES
    private String name; // default value of null
    private double total; // Initialize total to 0
    private boolean ready; // default value of false
    private ArrayList<Item> items; // defaults to null

    // CONSTRUCTOR
    // No arguments, sets name to "Guest", initializes items as an empty list.
    public Order() {
        this.name = "Guest";
        this.items = new ArrayList<Item>();
    }

    // OVERLOADED CONSTRUCTOR
    // Takes a name as an argument, sets name to this custom name.
    // Initializes items as an empty list.
    public Order(String name) {
        this.name = name;
        this.items = new ArrayList<Item>();
    }

    // ORDER METHODS
    public void addItem(Item item) {
        items.add(item);
    }

    public String getStatusMessage() {
        if (this.ready) {
            return this.name + "'s order is ready. \n \n";
        }
        return "Thank you for waiting, " + this.name + "'s order will be ready soon. \n \n";
    }

    public double getOrderTotal() {
        double total = 0; // Initialize the total to 0
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }
    

    public void display() {
        System.out.println("Customer Name: " + this.name);
        for (Item item : items) {
            System.out.println(item.getName() + " is $" + item.getPrice());
        }
        System.out.println("Total: $" + getOrderTotal() + "\n \n");
    }

    // GETTERS & SETTERS
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isReady() {
        return this.ready;
    }

    public boolean getReady() {
        return this.ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

}