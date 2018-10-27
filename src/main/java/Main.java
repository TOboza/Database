import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class Main  {

    public static void main(String[] args) throws java.sql.SQLException{
       String connectionString = "jdbc:mysql://localhost:3306/public_db";
       String connectionOptions = "?serverTimezone=UTC&useSSL=false&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true";
       String dbUser = "tomek";
       String dbPassword = "tomek";
       Properties prop = new Properties();

       prop.setProperty("user",dbUser);
       prop.setProperty("password",dbPassword);
       prop.setProperty("ssl","true");
       Connection conn = DriverManager.getConnection(connectionString+connectionOptions,prop);

       Statement statement =
    }
}
