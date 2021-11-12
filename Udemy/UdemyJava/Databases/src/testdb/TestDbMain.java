package testdb;

// add JDBC driver to project: file > project structure > libraries > + > select jar of the driver

import java.sql.*;

public class TestDbMain {
    // best practice: not hard-code stuff and instead create constants, so it is easy to change later
    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/vitorfreitas/dev/personal/hellojava/UdemyJava/Databases/" + DB_NAME;

    public static final String TABLE_CONTACTS = "contacts";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMNS = "(" + COLUMN_NAME + ", " + COLUMN_PHONE + ", " + COLUMN_EMAIL + ")";

    // CRUD of using jdbc
    public static void main(String[] args) {

        // how to interact with db: create statement, then use .execute() method to run sql code
        // best practice: use 'try with resources' to open db, so connection is closed when program finishes
        try (Connection conn = DriverManager.getConnection(CONNECTION_STRING);
             Statement statement = conn.createStatement()) {

            // changes are auto-commited by the JDBC connection object by default on each line ran, this command changes it if necessary
//            conn.setAutoCommit(false);

            // insert/update/delete data:
            // it is fine to re-use the same statement
            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
                    " (" + COLUMN_NAME + " TEXT, " + COLUMN_PHONE + " INTEGER, " + COLUMN_EMAIL + " TEXT)");

//            statement.execute("INSERT INTO " + TABLE_CONTACTS + " " + COLUMNS + " VALUES ('Joe', 6545678, 'joe@email.com')"); // bad way of doing it
            insertContact(statement, "Tom", 3456789, "tom@a.com");
            insertContact(statement, "Joe", 6545678, "joe@email.com");
            insertContact(statement, "Jane", 12345, "jane@email.com");
            insertContact(statement, "Dog", 45678, "dog@email.com");

            statement.execute("UPDATE " + TABLE_CONTACTS + " SET " + COLUMN_PHONE + "=556789 WHERE " + COLUMN_NAME + "='Jane'");
            statement.execute("DELETE FROM " + TABLE_CONTACTS + " WHERE " + COLUMN_NAME + "='Joe'");

            // query data:
            // you can re-use statements, but if you want to process different queries in parallel,
            // you need to use different statements
//            statement.execute("SELECT * FROM contacts");
//            ResultSet results = statement.getResultSet();

            // better way to do it: executeQuery() method already returns a ResultSet
            ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_CONTACTS);

            while (results.next()) {
                System.out.println(results.getString(COLUMN_NAME) + " " +
                                   results.getInt(COLUMN_PHONE) + " " +
                                   results.getString(COLUMN_EMAIL));
            }
            results.close();

            // needed if we were not using try with resources, but this is not needed here
//            statement.close();
//            conn.close();
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void insertContact(Statement statement, String name, int phone, String email) throws SQLException{
        String query = String.format("INSERT INTO %s %s VALUES ('%s', %d, '%s')",
                TABLE_CONTACTS,
                COLUMNS,
                name, phone, email);
        statement.execute(query);
    }
}
