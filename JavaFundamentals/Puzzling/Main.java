// To use methods from the Random library you will need to create an instance of Random

// Random randMachine=new Random();

// From there you can use any of the methods listed in the documentation. For example:

// randMachine.setSeed(35679); // <--- you won't need to use this method.

public class Main {
    public static void main(String[] args) {
        //! Create an instance of the PuzzleJava class
        PuzzleJava puzzleJava = new PuzzleJava();

        //! Print the result of rolling a 10-sided die 10 times
        System.out.println(puzzleJava.getTenRolls());

        //! Print a random letter
        System.out.println(puzzleJava.getRandomLetter());

        //! Print a random password
        System.out.println(puzzleJava.generatePassword());

        //! Print an array of random passwords of the specified length (param)
        System.out.println(puzzleJava.generateNewPassword(5));
    }
}
