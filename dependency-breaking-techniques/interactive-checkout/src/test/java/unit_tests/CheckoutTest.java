package unit_tests;

import checkout.Checkout;
import checkout.EmailService;
import checkout.OrderCancelledException;
import checkout.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class CheckoutTest {
    @Test
    public void order_cancelled_because_terms_are_not_accepted() {
        // note for tester:
        // Accept Newsletter
        // Do not Accept Terms
        var emailService = mock(EmailService.class);
        var polkaDotSocks = new Product("Polka-dot Socks");
        var checkout = new Checkout(polkaDotSocks, emailService);

        assertThrows(OrderCancelledException.class, checkout::confirmOrder);
    }
}

