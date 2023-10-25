public class TestOrders {
    public static void main(String[] args) {

        // Menu items
        Item item1 = new Item("drip coffee", 2.22);
        Item item2 = new Item("capuccino", 3.48);
        Item item3 = new Item("latte", 2.73);
        Item item4 = new Item("mocha", 1.76);

        // 2 unspecified orders
        // Order order1 = new Order();
        // Order order2 = new Order();

        // 3 named orders
        Order order1 = new Order("Sam");
        Order order2 = new Order("Cinhurri");
        Order order3 = new Order("Jimmy");
        Order order4 = new Order("Noah");

        // Add 2 items to each order and call display after
        order1.addItem(item4);
        order1.addItem(item3);

        order2.addItem(item1);
        order2.addItem(item3);
        order2.addItem(item3);

        order3.addItem(item4);
        order3.addItem(item3);

        order4.addItem(item2);
        order4.addItem(item3);

        // Access the name using the getter method
        System.out.printf("Name: %s\n", order1.getName());

    }
}