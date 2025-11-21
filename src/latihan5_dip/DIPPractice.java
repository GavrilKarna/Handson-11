package latihan5_dip;

import latihan5_dip.good.*;

public class DIPPractice {
    public static void main(String[] args) {

        // ===== PART 1: BAD PRACTICE =====
        System.out.println("=== BAD PRACTICE: Melanggar DIP ===\n");

        latihan5_dip.bad.PaymentService badService = new latihan5_dip.bad.PaymentService();
        badService.processPayment("4532-1234-5678-9010", 150000.0, "user@example.com");

        System.out.println("\n" + "=".repeat(70));

        // ===== PART 2: GOOD PRACTICE =====
        System.out.println("\n=== GOOD PRACTICE: Mengikuti DIP ===\n");

        System.out.println("--- Setup 1: Stripe Payment Gateway ---");

        CardValidator cardValidator = new LuhnCardValidator();
        FraudDetector fraudDetector = new RuleBasedFraudDetector();
        PaymentGateway stripeGateway = new StripePaymentGateway();
        TransactionLogger transactionLogger = new DatabaseTransactionLogger();
        NotificationSender notificationSender = new EmailNotificationSender();

        PaymentService stripePaymentService = new PaymentService(
                cardValidator,
                fraudDetector,
                stripeGateway,
                transactionLogger,
                notificationSender
        );

        stripePaymentService.processPayment("4532-1234-5678-9010", 150000.0, "user@example.com");

        System.out.println("\n" + "=".repeat(70));
        System.out.println("\n--- Setup 2: PayPal Payment Gateway ---");

        PaymentGateway paypalGateway = new PayPalPaymentGateway();

        PaymentService paypalPaymentService = new PaymentService(
                cardValidator,
                fraudDetector,
                paypalGateway,
                transactionLogger,
                notificationSender
        );

        paypalPaymentService.processPayment("4532-9876-5432-1098", 250000.0, "buyer@example.com");

        System.out.println("\n" + "=".repeat(70));
    }
}
