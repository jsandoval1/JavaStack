public class MammalTest {
    public static void main(String[] args) {
        // Create a Bat and display its initial energy
        Bat bat = new Bat();
        bat.displayEnergy("Bat");

        // Perform actions on the Bat
        bat.attackTown();
        bat.attackTown();
        bat.eatHumans();
        bat.eatHumans();
        bat.fly();

        // Display the Bat's energy after actions
        bat.displayEnergy("Bat");

        // Create a Gorilla and display its initial energy
        Gorilla gorilla = new Gorilla();
        gorilla.displayEnergy("Gorilla");

        // Perform actions on the Gorilla
        gorilla.throwSomething();
        gorilla.throwSomething();
        gorilla.eatBananas();
        gorilla.climb();

        // Display the Gorilla's energy after actions
        gorilla.displayEnergy("Gorilla");

    }
}
