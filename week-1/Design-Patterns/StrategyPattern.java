package designpatterns;

interface Payment {
    void pay(int amount);
}

class CreditCard implements Payment {

    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

class UPI implements Payment {

    public void pay(int amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}

class ShoppingCart {

    Payment payment;

    void setPayment(Payment payment) {
        this.payment = payment;
    }

    void checkout(int amount) {
        payment.pay(amount);
    }
}

public class StrategyPattern {

    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();

        cart.setPayment(new CreditCard());
        cart.checkout(1000);

        cart.setPayment(new UPI());
        cart.checkout(500);
    }
}