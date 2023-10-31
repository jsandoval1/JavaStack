package sandoval.john.hoppersreceipt.models;

// Define a class named Item
public class Item {

    // Define private attributes to represent an item
    private String name;
    private String itemName;
    private double price;
    private String description;
    private String vendor;

    // Default constructor for Item
    public Item() {
    }

    // Constructor that initializes item attributes
    public Item(String name, String itemName, double price, String description, String vendor) {
        // Set the name, item name, price, description, and vendor for the item
        this.name = name;
        this.itemName = itemName;
        this.price = price;
        this.description = description;
        this.vendor = vendor;
    }

    // Getter method to retrieve the name of the item
    public String getName() {
        return this.name;
    }

    // Setter method to set the name of the item
    public void setName(String name) {
        this.name = name;
    }

    // Getter method to retrieve the item name
    public String getItemName() {
        return this.itemName;
    }

    // Setter method to set the item name
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    // Getter method to retrieve the price of the item
    public double getPrice() {
        return this.price;
    }

    // Setter method to set the price of the item
    public void setPrice(double price) {
        this.price = price;
    }

    // Getter method to retrieve the description of the item
    public String getDescription() {
        return this.description;
    }

    // Setter method to set the description of the item
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter method to retrieve the vendor of the item
    public String getVendor() {
        return this.vendor;
    }

    // Setter method to set the vendor of the item
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    // Override the toString method to provide a string representation of the item
    @Override
    public String toString() {
        // Return a string with the item's name, item name, price, description, and vendor
        return "{" +
                " name='" + getName() + "'" +
                ", itemName='" + getItemName() + "'" +
                ", price='" + getPrice() + "'" +
                ", description='" + getDescription() + "'" +
                ", vendor='" + getVendor() + "'" +
                "}";
    }
}
