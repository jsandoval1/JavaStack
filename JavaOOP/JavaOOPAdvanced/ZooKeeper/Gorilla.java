public class Gorilla extends Mammal {

    // MEMBER VARIABLES

    // CONSTRUCTOR
    public Gorilla() {
    }

    // OVERLOADED CONSTRUCTOR

    // METHODS
    public void throwSomething() {
        int currentEnergy = getEnergy();
        currentEnergy -= 10;
        setEnergy(currentEnergy);
        System.out.println("Threw something. Current energy: " + currentEnergy);
    }

    public void eatBananas() {
        int currentEnergy = getEnergy();
        int eatingBananas = 10;
        currentEnergy += eatingBananas;
        setEnergy(currentEnergy);
        System.out.println("Ate bananas. Current energy: " + currentEnergy);
    }

    public void climb() {
        int currentEnergy = getEnergy();
        int climbedTree = 10;
        currentEnergy -= climbedTree;
        setEnergy(currentEnergy);
        System.out.println("Gorilla climbed tree. Current energy: " + currentEnergy);
    }

    // GETTERS & SETTERS

}
