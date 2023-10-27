public class Bat extends Mammal {

    // MEMBER VARIABLES
    // ! Override dpes not go here but instead in the constructor
    // private int energy = 300;

    // CONSTRUCTOR
    public Bat() {
        //* Set the initial energy level for the Bat to 300
        setEnergy(300);
    }

    // OVERLOADED CONSTRUCTOR

    // METHODS
    public void fly() {
        int currentEnergy = getEnergy();
        currentEnergy -= 50;
        setEnergy(currentEnergy);
        System.out.println("Bat flew. Current energy: " + currentEnergy);
    }

    public void eatHumans() {
        int currentEnergy = getEnergy();
        int eatingHumans = 25;
        currentEnergy += eatingHumans;
        setEnergy(currentEnergy);
        System.out.println("Bat fed on humans. Current energy: " + currentEnergy);
    }

    public void attackTown() {
        int currentEnergy = getEnergy();
        int attackedTown = 100;
        currentEnergy -= attackedTown;
        setEnergy(currentEnergy);
        System.out.println("Bat attacked town. Current Energy: " + currentEnergy);
    }

    // GETTERS & SETTERS

}
