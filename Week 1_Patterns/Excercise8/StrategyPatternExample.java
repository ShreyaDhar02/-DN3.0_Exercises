    interface PaymentStrategy {
        void pay(double amount);
    }

    // CreditCardPayment.java
    class CreditCardPayment implements PaymentStrategy {
        @Override
        public void pay(double amount) {
            System.out.println("Paying $" + amount + " using Credit Card");
        }
    }

    // PayPalPayment.java
    class PayPalPayment implements PaymentStrategy {
        @Override
        public void pay(double amount) {
            System.out.println("Paying $" + amount + " using PayPal");
        }
    }

    // PaymentContext.java
    class PaymentContext {
        private PaymentStrategy pStrategy;

        public PaymentContext(PaymentStrategy pStrategy) {
            this.pStrategy = pStrategy;
        }

        public void setPaymentStrategy(PaymentStrategy pStrategy) {
            this.pStrategy = pStrategy;
        }

        public void executePayment(double amount) {
            pStrategy.pay(amount);
        }
    }
    public class StrategyPatternExample {
        public static void main(String[] args) {
            PaymentContext paymentContext = new PaymentContext(new CreditCardPayment());
            paymentContext.executePayment(100.0);

            paymentContext.setPaymentStrategy(new PayPalPayment());
            paymentContext.executePayment(200.0);
        }
    }