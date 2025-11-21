package latihan5_dip.bad;

public class FraudDetector {
    public boolean checkFraud(String cardNumber, double amount) {
        System.out.println("[FraudDetector] Checking fraud for amount: " + amount);

        if (amount > 1000000.0) {
            System.out.println("[FraudDetector] FRAUD DETECTED - Amount too high!");
            return true;
        }
        System.out.println("[FraudDetector] No fraud detected");
        return false;
    }
}
