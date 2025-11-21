package latihan5_dip.good;

public class EmailNotificationSender implements NotificationSender {

    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("[EmailNotificationSender] Sending email to: " + recipient);
        System.out.println("[EmailNotificationSender] Subject: " + message);
    }
}
