package problematic_searcher;

import java.sql.*;
import java.util.*;

public class PersonsRepository {
    private static final String DATABASE_NAME = "myshop";
    private static final String USER = "store";
    private static final String PASS = "123456";

    public static List<Person> query(String sql) {
        Logger.log(sql);
        List<Person> persons = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE_NAME, USER, PASS)) {
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    persons.add(new Person(resultSet.getString(1), resultSet.getString(2)));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for(Person person : persons){
            Logger.log(person.toString());
        }
        return persons;
    }
}