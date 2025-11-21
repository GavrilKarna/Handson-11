package latihan5_dip.good;

public class RuleBasedFraudDetector implements FraudDetector {

    @Override
    public boolean checkFraud(String cardNumber, double amount) {
        System.out.println("[RuleBasedFraudDetector] Checking fraud with rules for amount: " + amount);

        if (amount > 1000000.0) {
            System.out.println("[RuleBasedFraudDetector] FRAUD DETECTED ✗");
            return true;
        }

        System.out.println("[RuleBasedFraudDetector] No fraud detected ✓");
        return false;
    }
}
