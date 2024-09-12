package checkout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Receipt {
    private Money amount;
    private Money tax;
    private Money total;

    public Receipt(Money amount, Money tax, Money total) {
        this.amount = amount;
        this.tax = tax;
        this.total = total;
    }

    public Money getAmount() {
        return amount;
    }

    public Money getTax() {
        return tax;
    }

    public Money getTotal() {
        return total;
    }

    public List<String> format() {
        List<String> receipt = new ArrayList<>();
        receipt.add("Receipt");
        receipt.add("=======");
        receipt.add("Item 1 ... " + amount.format());
        receipt.add("Tax    ... " + tax.format());
        receipt.add("----------------");
        receipt.add("Total  ... " + total.format());
        return receipt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receipt receipt = (Receipt) o;
        return Objects.equals(amount, receipt.amount) && Objects.equals(tax, receipt.tax) && Objects.equals(total, receipt.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, tax, total);
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "amount=" + amount +
                ", tax=" + tax +
                ", total=" + total +
                '}';
    }
}