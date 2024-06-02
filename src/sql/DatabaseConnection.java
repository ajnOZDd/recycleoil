package sql ;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection  {
    private Connection connection;

    public DatabaseConnection(String host, String database, String username, String password) {
        this.connection = getConnection(host, database, username, password);
    }

    private Connection getConnection(String host, String database, String username, String password) {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(
                    "jdbc:postgresql://" + host + "/" + database,
                    username,
                    password
            );
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error closing the database connection", e);
        }
    }

   

    public Connection getConnection() {
        return connection;
    }
}