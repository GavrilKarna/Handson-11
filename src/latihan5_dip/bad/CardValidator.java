package latihan5_dip.bad;

public class CardValidator {
    public boolean validate(String cardNumber) {
        System.out.println("[CardValidator] Validating card: " + cardNumber);

        if (cardNumber == null || cardNumber.replace("-", "").length() != 16) {
            System.out.println("[CardValidator] Card is invalid");
            return false;
        }
        System.out.println("[CardValidator] Card is valid");
        return true;
    }
}
