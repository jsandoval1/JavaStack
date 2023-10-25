import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {

    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> getTenRolls = new ArrayList<>();
        Random randMachine = new Random();
        for (int i = 0; i < 10; i++) {
            getTenRolls.add(randMachine.nextInt(20));
        }
        return getTenRolls;
    };

    public char getRandomLetter() {
        char[] myArray = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
                'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        Random randMachine = new Random();
        return myArray[randMachine.nextInt(26)];
    };

    public String generatePassword() {
        String password = "";
        for (int i = 0; i < 8; i++) {
            password += getRandomLetter();
        }
        return password;
    };

    public ArrayList<String> generateNewPassword(int numofPasswords) {
        ArrayList<String> passwords = new ArrayList<>();
        for (int i = 0; i < numofPasswords; i++) {
            passwords.add(generatePassword());
        }
        return passwords;
    }
}