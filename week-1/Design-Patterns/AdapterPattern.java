package designpatterns;

interface PaymentGateway {
    void pay(double amount);
}

class PayPal {

    void payment(double amount) {
        System.out.println("Paid Rs." + amount + " using PayPal");
    }
}

class Stripe {

    void paymentDone(double amount) {
        System.out.println("Paid Rs." + amount + " using Stripe");
    }
}

class PayPalAdapter implements PaymentGateway {

    PayPal paypal;

    PayPalAdapter(PayPal paypal) {
        this.paypal = paypal;
    }

    public void pay(double amount) {
        paypal.payment(amount);
    }
}

class StripeAdapter implements PaymentGateway {

    Stripe stripe;

    StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    public void pay(double amount) {
        stripe.paymentDone(amount);
    }
}

public class AdapterPattern {

    public static void main(String[] args) {

        PaymentGateway p1 = new PayPalAdapter(new PayPal());
        p1.pay(500);

        PaymentGateway p2 = new StripeAdapter(new Stripe());
        p2.pay(750);

        System.out.println("Payment Completed");
    }
}