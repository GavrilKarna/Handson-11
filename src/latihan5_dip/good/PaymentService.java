package latihan5_dip.good;

public class PaymentService {

    private final CardValidator cardValidator;
    private final FraudDetector fraudDetector;
    private final PaymentGateway paymentGateway;
    private final TransactionLogger transactionLogger;
    private final NotificationSender notificationSender;

    public PaymentService(
            CardValidator cardValidator,
            FraudDetector fraudDetector,
            PaymentGateway paymentGateway,
            TransactionLogger transactionLogger,
            NotificationSender notificationSender) {

        this.cardValidator = cardValidator;
        this.fraudDetector = fraudDetector;
        this.paymentGateway = paymentGateway;
        this.transactionLogger = transactionLogger;
        this.notificationSender = notificationSender;
    }

    public void processPayment(String cardNumber, double amount, String customerEmail) {

        if (!cardValidator.validate(cardNumber)) {
            System.out.println("Payment failed: Invalid card");
            return;
        }

        if (fraudDetector.checkFraud(cardNumber, amount)) {
            System.out.println("Payment failed: Fraud detected");
            return;
        }

        String transactionId = paymentGateway.charge(cardNumber, amount);

        transactionLogger.log(transactionId, amount, "SUCCESS");

        notificationSender.sendNotification(customerEmail,
                "Payment Successful - Amount: Rp " + amount);
    }
}
