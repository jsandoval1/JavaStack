public class Mammal {
    
    // MEMBER VARIABLES
    private int energy = 100;

    // CONSTRUCTOR
    public Mammal() {
    }


    // OVERLOADED CONSTRUCTOR
    public Mammal(int energy) {
        this.energy = energy;
    }

    // METHODS
    // ? Basic way of doing it
    // public void displayEnergy() {
    //     System.out.println("Energy Level: " + energy);
    // }

    // *Better way of doing it to print mammal type when testing
    public void displayEnergy(String mammalType) {
        System.out.println(mammalType + " Energy Level: " + energy);
    }

    // GETTERS & SETTERS
    public int getEnergy() {
        return this.energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
    
}
