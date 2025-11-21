package latihan5_dip.good;

public class LuhnCardValidator implements CardValidator {

    @Override
    public boolean validate(String cardNumber) {
        System.out.println("[LuhnCardValidator] Validating card using Luhn algorithm: " + cardNumber);

        String clean = cardNumber.replace("-", "");

        if (clean.length() != 16) {
            System.out.println("[LuhnCardValidator] Card is invalid ✗");
            return false;
        }
        System.out.println("[LuhnCardValidator] Card is valid ✓");
        return true;
    }
}
