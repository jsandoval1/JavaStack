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
    public void displayEnergy() {
        System.out.println("Energy Level: " + energy);
    }

    // GETTERS & SETTERS
    public int getEnergy() {
        return this.energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
    
}
