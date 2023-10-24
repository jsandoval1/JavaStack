public class AlfredTest {
    /*
     * This main method will always be the launch point for a Java application
     * For now, we are using the main to test all our
     * AlfredQuotes methods.
     */
    public static void main(String[] args) {
        // Make an instance of AlfredQuotes to access all its methods.
        AlfredQuotes alfredBot = new AlfredQuotes();

        // Make some test greetings, providing any necessary data
        String testGreeting = alfredBot.basicGreeting();

        String testGuestGreeting = alfredBot.guestGreeting("Beth Kane"); //! Beth Kane is the param passed in

        String testDateAnnouncement = alfredBot.dateAnnouncement(); //! We do not pass parameters as we are making an instance in the method of current data

        String alexisTest = alfredBot.respondBeforeAlexis(
                "Alexis! Play some low-fi beats."); //! These are the phrases (method)respondBeforeAlexis is searching in

        String alfredTest = alfredBot.respondBeforeAlexis(
                "I can't find my yo-yo. Maybe Alfred will know where it is."); //! These are the phrases (method)respondBeforeAlexis is searching in

        String notRelevantTest = alfredBot.respondBeforeAlexis(
                "Maybe that's what Batman is about. Not winning. But failing.."); //! These are the phrases (method)respondBeforeAlexis is searching in

        // Print the greetings to test.
        System.out.println(testGreeting);

        // Uncomment these one at a time as you implement each method.
        System.out.println(testGuestGreeting);

        System.out.println(testDateAnnouncement);

        System.out.println(alexisTest);

        System.out.println(alfredTest);

        System.out.println(notRelevantTest);
    }
}
