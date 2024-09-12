package unit_tests;

import checkout.Checkout;
import checkout.Money;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CheckoutTest {
    @Test
    public void creates_a_receipt() {
        var checkout = new Checkout();

        checkout.createReceipt(Money.amount(12));

        assertThat(true, is(false));
    }
}

