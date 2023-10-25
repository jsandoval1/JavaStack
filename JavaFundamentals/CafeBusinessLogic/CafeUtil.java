import java.util.ArrayList;

public class CafeUtil {

    public int getStreakGoal( int numWeeks ) {
        int sum = 0;
        for (int i = 1; i <= numWeeks; i++) {
            sum += i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices) { //! Prices is just a placeholder for parameter
        double sum = 0;
        for (int i = 0; i < prices.length; i++){
            sum += prices[i];
        }
        return sum;
    }

    public void displayMenu(ArrayList<String> menuItems) { //! Takes an ArrayList of strings as param
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i + " " + menuItems.get(i)); //! i = Index Position VS. menuItem.get(i) is getting the actual string
        }
    }

    public void addCustomer(ArrayList<String> customers) { //! Takes an ArrayList of strings as param
        String username = System.console().readLine(); //! Reads a line of text (a customer's username) from the console input and stores it in the username variable
        System.out.println("welcome " + username);
        customers.add(username); //! Username is added to the customers ArrayList
        System.out.println(customers); //! Prints the current list of customers (the customers ArrayList)
        System.out.println("you are " + customers.size() + " in line"); // ! Counts the number of elements in the customers ArrayList using the size() method and prints the result
    }

}