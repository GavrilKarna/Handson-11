package latihan5_dip.good;

public class DatabaseTransactionLogger implements TransactionLogger {

    @Override
    public void log(String transactionId, double amount, String status) {
        System.out.println("[DatabaseTransactionLogger] Logging to database: " +
                transactionId + ", Amount: " + amount + ", Status: " + status);
    }
}
