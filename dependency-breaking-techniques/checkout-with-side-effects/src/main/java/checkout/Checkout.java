package checkout;

public class Checkout {

    public Receipt createReceipt(Money amount) {
        Money vat = amount.percentage(21);
        Receipt receipt = new Receipt(amount, vat, amount.add(vat));
        ReceiptRepository.store(receipt);
        return receipt;
    }
}