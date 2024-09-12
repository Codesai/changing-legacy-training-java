package checkout;

public class Checkout {

    private final EmailService emailService;

    private final UserConfirmation newsLetterSubscribed;
    private final Product product;

    private final UserConfirmation termsAndConditionsAccepted;

    public Checkout(Product product, EmailService emailService) {
        this.product = product;
        this.emailService = emailService;
        this.newsLetterSubscribed = new UserConfirmation("Subscribe to our product " + product.toString() + " newsletter?");
        this.termsAndConditionsAccepted = new UserConfirmation(
                "Accept our terms and conditions?\n" +
                        "(Mandatory to place order for " + product + ")");
    }

    public void confirmOrder() {
        if (!termsAndConditionsAccepted.wasAccepted()) throw new OrderCancelledException(product);
        if (newsLetterSubscribed.wasAccepted()) emailService.subscribeUserFor(product);
    }
}