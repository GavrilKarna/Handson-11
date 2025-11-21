package latihan5_dip.bad;

// MASALAH: High-level module directly depend on concrete classes
// PaymentService tightly coupled dengan implementasi konkrit
public class PaymentService {

    // MASALAH: Directly depend on concrete classes
    private CardValidator cardValidator;
    private FraudDetector fraudDetector;
    private PaymentGateway paymentGateway;
    private TransactionLogger transactionLogger;
    private NotificationSender notificationSender;

    public PaymentService() {
        // MASALAH: Create dependencies di dalam constructor
        // Tight coupling - tidak bisa ganti implementasi
        this.cardValidator = new CardValidator();
        this.fraudDetector = new FraudDetector();
        this.paymentGateway = new PaymentGateway();
        this.transactionLogger = new TransactionLogger();
        this.notificationSender = new NotificationSender();
    }

    public void processPayment(String cardNumber, double amount, String customerEmail) {
        // Step 1: Validate card
        if (!cardValidator.validate(cardNumber)) {
            System.out.println("Payment failed: Invalid card");
            return;
        }

        // Step 2: Check fraud
        if (fraudDetector.checkFraud(cardNumber, amount)) {
            System.out.println("Payment failed: Fraud detected");
            return;
        }

        // Step 3: Charge payment
        String transactionId = paymentGateway.charge(cardNumber, amount);

        // Step 4: Log transaction
        transactionLogger.log(transactionId, amount, "SUCCESS");

        // Step 5: Send notification
        notificationSender.sendNotification(customerEmail, "Payment Successful");
    }
}
