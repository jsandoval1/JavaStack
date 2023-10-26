public class Phone extends Device {

    // MEMBER VARIABLES

    // CONSTRUCTOR
    public Phone() {
    }

    // OVERLOADED CONSTRUCTOR

    // METHODS
    public void makePhoneCall() {
        int currentBatteryLife = getBatteryLife(); // Used as a temporary variable within this method only
        currentBatteryLife -= 5;
        setBatteryLife(currentBatteryLife);
        System.out.println("Making a phone call. Battery Life: " + currentBatteryLife);
    }

    public void playGame() {
        int currentBatteryLife = getBatteryLife(); // Used as a temporary variable within this method only
        currentBatteryLife -= 20;
        setBatteryLife(currentBatteryLife);
        System.out.println("Playing a game. Battery Life: " + currentBatteryLife);
    }

    //* Alternate way of doing it
    public void chargePhone() {
        int currentBatteryLife = getBatteryLife();
        int chargeAmount = 50; //* Use a constant to define the battery increase value
        currentBatteryLife += chargeAmount;
        setBatteryLife(currentBatteryLife);
        System.out.println("Charging the phone. Battery Life: " + currentBatteryLife);
    }
    
    // GETTERS & SETTERS    

}
