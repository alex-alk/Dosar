import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Migration_1648820328961_create_users_table{
    public static void run() {
        Connection con = Migrate.getConnection();
        try {
            Statement stmt = con.createStatement();
            stmt.execute(
        		"CREATE TABLE users (" +
            		"id NUMBER(10, 0) GENERATED ALWAYS AS IDENTITY," +
            		"username VARCHAR2(100) NOT NULL," +
            		"password VARCHAR2(100) NOT NULL," +
            		"PRIMARY KEY(id)" +
        		")"
    		);
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}