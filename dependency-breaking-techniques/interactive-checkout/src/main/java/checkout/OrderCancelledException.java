package checkout;

public class OrderCancelledException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public OrderCancelledException(Product product) {
        super(product.getName());
    }
}