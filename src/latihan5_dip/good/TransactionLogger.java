package latihan5_dip.good;

public interface TransactionLogger {
    void log(String transactionId, double amount, String status);
}
