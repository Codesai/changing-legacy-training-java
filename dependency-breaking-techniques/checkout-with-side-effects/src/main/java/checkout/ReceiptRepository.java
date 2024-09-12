package checkout;

import java.sql.*;

public class ReceiptRepository {

    private static final String DatabaseName = "myshop";
    private static final String User = "store";
    private static final String Pass = "123456";

    public static void store(Receipt receipt) {
        String url = "jdbc:mysql://localhost:3306/" + DatabaseName + "?serverTimezone=UTC";

        try (Connection connection = DriverManager.getConnection(url, User, Pass)) {
            String query = "insert into RECEIPT (AMOUNT, TAX, TOTAL) values (?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setBigDecimal(1, receipt.getAmount().getValue());
                preparedStatement.setBigDecimal(2, receipt.getTax().getValue());
                preparedStatement.setBigDecimal(3, receipt.getTotal().getValue());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}