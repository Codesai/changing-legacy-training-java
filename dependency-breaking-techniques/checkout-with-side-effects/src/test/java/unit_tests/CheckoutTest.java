package unit_tests;

import checkout.Checkout;
import checkout.Money;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckoutTest {
    @Test
    public void creates_a_receipt() {
        var checkout = new Checkout();

        checkout.createReceipt(Money.amount(12));

        assertThat(true).isEqualTo(false);
    }
}

