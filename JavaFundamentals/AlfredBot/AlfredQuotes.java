import java.util.Date;

public class AlfredQuotes {

    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }

    public String guestGreeting(String name) {
        return String.format("Hello, %s, Lovely to see you.", name);
    }

    // ! Doesn't take any parameters. Inside the method, it creates
    // ! a Date object (currentDate) to represent the current date and time
    public String dateAnnouncement() {
        Date currentDate = new Date();
        return String.format("It is currently %s", currentDate);
    }

    // ! if Statements are checking to see if "Alexis" or "Alfred" are in the phrase passed in.
    // ! The >-1 condition means that the code inside the if block will execute 
    // ! if "Alexis" or "Alfred" is found, as -1 indicates "not found".
    public String respondBeforeAlexis(String phrase) {

        if(phrase.indexOf("Alexis") > -1) {
            return "She's really of no help. What can I get for you?";
        }

        if (phrase.indexOf("Alfred") > -1) {
            return "At your service, naturally. How may I be of assistance?";
        }

        return "Right. And with that I shall retire.";
    }

    // NINJA BONUS
    // See the specs to overload the guestGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have
    // learned!
}
