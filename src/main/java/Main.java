import java.sql.*;
import java.util.Date;
import java.util.Properties;

public class Main  {

    public static void main(String[] args) throws java.sql.SQLException{

      // insertRun(1,"Bieg","Rzeszów",new Date(),new Date(),100);

      //deleteRun(1);
       

    }

    private static void insertRun(Integer id, String name,
                                  String place,Date start_date,Date start_time, Integer members_limit)throws SQLException {
       Connection connection = JdbcUtils.getInstance().getConnection();
       PreparedStatement statement = connection.prepareStatement("insert into " +
               "runs(id,name,place,start_date,start_time,members_limit) values (?,?,?,?,?,?)");

       statement.setInt(1,id);
       statement.setString(2,name);
       statement.setString(3,place);

       java.sql.Date sqlStartDate = new java.sql.Date(start_date.getTime());
       java.sql.Date sqlStartTime = new java.sql.Date(start_time.getTime());
       statement.setDate(4,sqlStartDate);
       statement.setDate(5,sqlStartTime);
       statement.setInt(6,members_limit);
       statement.executeUpdate();

    }

   private static void deleteRun(Integer id) throws SQLException{
      Connection connection = JdbcUtils.getInstance().getConnection();
      PreparedStatement statement = connection.prepareStatement("delete from runs where id=?");
      statement.setInt(1,id);
      statement.executeUpdate();
   }

}
