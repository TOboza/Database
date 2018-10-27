import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils  {
    private final static JdbcUtils instance  = new JdbcUtils();
    private Connection connection;
    private JdbcUtils() {

        try {
            String connectionString = "jdbc:mysql://localhost:3306/public_db";
            String connectionOptions = "?serverTimezone=UTC&useSSL=false&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true";
            String dbUser = "tomek";
            String dbPassword = "tomek";
            Properties prop = new Properties();

            prop.setProperty("user", dbUser);
            prop.setProperty("password", dbPassword);
            prop.setProperty("ssl", "true");
            connection = DriverManager.getConnection(connectionString + connectionOptions, prop);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static JdbcUtils getInstance() {
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
