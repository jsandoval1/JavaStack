// To use methods from the Random library you will need to create an instance of Random

// Random randMachine=new Random();

// From there you can use any of the methods listed in the documentation. For example:

// randMachine.setSeed(35679); // <--- you won't need to use this method.

public class Main {
    public static void main(String[] args) {
        PuzzleJava puzzleJava = new PuzzleJava();
        System.out.println(puzzleJava.getTenRolls());

        System.out.println(puzzleJava.getRandomLetter());
        System.out.println(puzzleJava.generatePassword());

        System.out.println(puzzleJava.generateNewPassword(5));
    }
}