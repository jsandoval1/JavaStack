public class TestOrders {
    public static void main(String[] args) {

        // Menu items
        Item item1 = new Item("drip coffee", 2.22);
        Item item2 = new Item("capuccino", 3.48);
        Item item3 = new Item("latte", 2.73);
        Item item4 = new Item("mocha", 1.76);

        // 4 named orders
        Order order1 = new Order("Sam");
        Order order2 = new Order("Cinhurri");
        Order order3 = new Order("Jimmy");
        Order order4 = new Order("Noah");

        // 2 Unnamed Guests
        Order order5 = new Order();
        Order order6 = new Order();
        
        // Add 2 items to each order and call display after
        order1.addItem(item3);
        order1.addItem(item3);
        order1.addItem(item3);
        order1.addItem(item4);

        order2.addItem(item1);

        order3.addItem(item3);
        order3.addItem(item4);

        order4.addItem(item2);
        order4.addItem(item2);
        order4.addItem(item3);

        // Added the the Unnamed guests orders 
        order5.addItem(item1);
        order6.addItem(item2);
        
        // Access the name using the getter method
        System.out.printf("Name is: %s \n", order1.getName());
        
        //! Predict what will happen if you print 'order1.total'
        System.out.printf("Price: %f \n \n", order1.getTotal());
            // ! Displayed total as 0.0?
        
        // Added a Cappuccino to Noah's order, display new.
        order4.display();

        // Sam added a latte.
        // Line 21
        // * order1.display(); THIS GETS OUTDATED BECAUSE SAM GETS MORE DRINKS

        // Cindhuris order is ready, update her status.
        // * I was playing with the toggle setting on true and false
        order2.setReady(false);
        System.out.printf(order2.getStatusMessage());
        
        // Sam ordered more drinks - 2 lattes. Update their order as well.
        order1.display();

        // Jimmy’s order is now ready. Update his status.
        order3.setReady(true);
        System.out.printf(order3.getStatusMessage());

        //Displaying the orders of the two unnamed guests
        order5.display();
        order6.display();
    }
}