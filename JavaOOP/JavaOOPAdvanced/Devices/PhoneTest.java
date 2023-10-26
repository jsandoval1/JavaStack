public class PhoneTest {
    public static void main(String[] args) {
        // Instantiate the Phone class
        Phone myPhone = new Phone();
        
        // Display initial battery life, coming from Device Class
        myPhone.displayBatteryLife();
        
        // Make three phone calls
        myPhone.makePhoneCall();
        myPhone.makePhoneCall();
        myPhone.makePhoneCall();
        
        // Play a game twice
        myPhone.playGame();
        myPhone.playGame();
        
        // Charge the phone
        myPhone.chargePhone();
        
        // Display battery life after all actions, coming from Device Class
        myPhone.displayBatteryLife();
    }
}
