package designpatterns;

interface Notification {
    void sendMessage();
}

class EmailNotification implements Notification {

    public void sendMessage() {
        System.out.println("Email Sent");
    }
}

class SMSNotification implements Notification {

    public void sendMessage() {
        System.out.println("SMS Sent");
    }
}

class NotificationFactory {

    public Notification getNotification(String type) {

        if (type.equals("Email")) {
            return new EmailNotification();
        } else if (type.equals("SMS")) {
            return new SMSNotification();
        }

        return null;
    }
}

public class FactoryPattern {

    public static void main(String[] args) {

        NotificationFactory factory = new NotificationFactory();

        Notification n1 = factory.getNotification("Email");
        n1.sendMessage();

        Notification n2 = factory.getNotification("SMS");
        n2.sendMessage();
    }
}