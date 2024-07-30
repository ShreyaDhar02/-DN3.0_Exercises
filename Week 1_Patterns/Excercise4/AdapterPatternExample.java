interface PaymentProcessor {
    void processPayment(String paymentDetails);
}

// PayPal.java
class PayPal {
    public void makePayment(String paymentDetails) {
        System.out.println("Processing payment through PayPal: " + paymentDetails);
    }
}

// PhonePe.java
class PhonePe{
    public void payVia(String paymentDetails) {
        System.out.println("Processing payment through Stripe: " + paymentDetails);
    }
}

// PayPalAdapter.java
class PayPalAdapter implements PaymentProcessor {
    private PayPal paypal;

    public PayPalAdapter(PayPal paypal) {
        this.paypal = paypal;
    }

    @Override
    public void processPayment(String paymentDetails) {
        paypal.makePayment(paymentDetails);
    }
}

// StripeAdapter.java
class PhonePeAdapter implements PaymentProcessor {
    private PhonePe phonepe;

    public PhonePeAdapter(PhonePe phonepe) {
        this.phonepe = phonepe;
    }

    @Override
    public void processPayment(String paymentDetails) {
        phonepe.payVia(paymentDetails);
    }
}

public class AdapterPatternExample {
    public static void main(String[] args) {
        // Create instances of payment gateways
        PayPal paypal = new PayPal();
        PhonePe phonepe = new PhonePe();

        // Create adapters for payment gateways
        PaymentProcessor paypalAdapter = new PayPalAdapter(paypal);
        PaymentProcessor phonepeAdapter = new PhonePeAdapter(phonepe);

        // Process payments through adapters
        paypalAdapter.processPayment("Payment details for PayPal");
        phonepeAdapter.processPayment("Payment details for PhonePe");
    }
}
  