package latihan5_dip.good;

public interface PaymentGateway {
    String charge(String cardNumber, double amount);
}
