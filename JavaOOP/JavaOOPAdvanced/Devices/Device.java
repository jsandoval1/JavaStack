public class Device {

    // MEMBER VARIABLES
    private int batteryLife = 100;

    // CONSTRUCTOR
    public Device() {
    }

    // OVERLOADED CONSTRUCTOR
    public Device(int batteryLife) {
        this.batteryLife = batteryLife;
    }

    // METHODS
    public void displayBatteryLife() {
        System.out.println("Battery Life: " + batteryLife);
    }

    // GETTERS & SETTERS
    public int getBatteryLife() {
        return this.batteryLife;
    }

    public void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
    }

}
