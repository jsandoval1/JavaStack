import java.util.ArrayList;
// Here we're creating a new data type called order

public class Order {

    // MEMBER VARIABLES
    private String name; // default value of null
    private double total; // Initialize total to 0
    private boolean ready; // default value of false
    private ArrayList<Item> items; // defaults to null, Array list of //*Item* objects

    // CONSTRUCTOR
    // No arguments, Uses this constructor, sets name to "Guest", initializes items as an empty list.
    public Order() {
        this.name = "Guest";
        this.items = new ArrayList<Item>();
    }

    // OVERLOADED CONSTRUCTOR
    // When a name is as an argument, sets name to this custom name.
    // Initializes items as an empty list.
    public Order(String name) {
        this.name = name;
        this.items = new ArrayList<Item>();
    }

    // ORDER METHODS
    // Allows you to add an Item object to the Array items list of the order.
    public void addItem(Item item) {
        items.add(item); //Passes Item objects created in the MainTest to the array items
    }

    // If the ready flag is true, it says that the order is ready with the customer's name. 
    // If ready is false, it says that the order will be ready soon with the customer's name.
    public String getStatusMessage() {
        if (this.ready) {
            return this.name + "'s order is ready. \n \n"; 
        }
        return "Thank you for waiting, " + this.name + "'s order will be ready soon. \n \n";
    }

    //  Iterates through the items list, adding up the prices of each item to calculate the total cost.
    public double getOrderTotal() {
        double total = 0; 
        for (Item item : items) { // loops through item array
            total += item.getPrice(); // getPrice method from Item Class
        }
        return total;
    }
    

    // Displays the customer's name, lists the items and their prices, and shows the total cost of the order.
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

    public String getCustomerName() {
        return name;
    }

}

// ! CODING DOJO VERSION 
import java.util.ArrayList;
// Here we're creating a new data type called order

public class Order {

    // MEMBER VARIABLES
    private String name; // default value of null
    private boolean ready; // default value of false
    private ArrayList<Item> items; // defaults to null

    // CONSTRUCTOR
    // No arguments, sets name to "Guest", initializes items as an empty list.
    public Order(){
        this.name = "Guest";
        this.items = new ArrayList<Item>();
    }

    // OVERLOADED CONSTRUCTOR
    // Takes a name as an argument, sets name to this custom name.
    // Initializes items as an empty list.
    public Order(String name){
        this.name = name;
        this.items = new ArrayList<Item>();
    }
    
    // ORDER METHODS
    
    	// Most of your code will go here, 
    	// so implement the getters and setters first!

    public void addItem(Item item){
        items.add(item);
    }

    public String getStatusMessage(){
        if(this.ready){
            return "Your order is ready.";
        }
        return "Thank you for waiting, your order will be ready soon.";
    }

    public double getOrderTotal(){
        double total = 0;
        for(Item item : items){
            total += item.getPrice();
        }
        return total;
    }

    public void display(){
        System.out.println("Customer Name: "+this.name);
        for(Item item : items){
            System.out.println(item.getName()+" - $"+item.getPrice());
        }
        System.out.println("Total: $"+getOrderTotal());
    }
    
    // GETTERS & SETTERS
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public boolean getReady(){
        return this.ready;
    }

    public void setReady(boolean ready){
        this.ready = ready;
    }

    public ArrayList<Item> getItems(){
        return this.items;
    }

    public void setItems(ArrayList<Item> items){
        this.items = items;
    }
}