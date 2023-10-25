import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {

    public ArrayList<Integer> getTenRolls() { //! Defines a method named getTenRolls and returns an ArrayList of integers (ArrayList<Integer>)
        ArrayList<Integer> getTenRolls = new ArrayList<>(); //!  Creates the ArrayList of integers named getTenRolls
        Random randMachine = new Random();
        for (int i = 0; i < 10; i++) {
            getTenRolls.add(randMachine.nextInt(20)); //! Generates a random number between 0 (inclusive) and 20 (exclusive) and adds it to the getTenRolls ArrayList
        }
        return getTenRolls; //! Returns the getTenRolls ArrayList
    };

    public char getRandomLetter() { //! Defines a method named getRandomLetter and is designed to return a random letter.
        char[] myArray = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', //! Creates an array named myArray
                'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        Random randMachine = new Random();
        return myArray[randMachine.nextInt(26)]; 
            //!  Generates a random integer between 0 (inclusive) and 26 (exclusive) using randMachine.nextInt(26). 
                //! Uses this random number as an index to access a character in the myArray array.
                    //! Selected character (letter) is returned as the result of the method.
    };

    public String generatePassword() { //! Defines a method named generatePassword and it will return a string
        String password = ""; //! Created an empty string to push random letters into
        for (int i = 0; i < 8; i++) { //! Set the length of the password string of random letters 
            password += getRandomLetter(); 
                //! Borrow getrandomLetter from same class function to generate random letter and return random char
                    // ! Add those new char into the password string 8 times
        }
        return password; //! Returns the created password 
    };

    public ArrayList<String> generateNewPassword(int numofPasswords) {  
        //! Defines a method named generateNewPassword and returns an ArrayList of strings (ArrayList<String>)
            // ! And takes an integer numofPasswords as a parameter, indicating how many passwords to generate
        ArrayList<String> passwords = new ArrayList<>(); //! Creates an empty ArrayList named passwords that will store the generated passwords.
        for (int i = 0; i < numofPasswords; i++) { //! Loop will run as many times as specified by the numofPasswords parameter.
            passwords.add(generatePassword()); 
                //! generatePassword method is called to generate a random password. This password is then added to the passwords ArrayList using the add method.
        }
        return passwords; //! Returns the passwords ArrayList
    }
}