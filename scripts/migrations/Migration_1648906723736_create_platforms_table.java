import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Migration_1648906723736_create_platforms_table{
    public static void run() {
        Connection con = Migrate.getConnection();
        try {
            Statement stmt = con.createStatement();
            stmt.execute(
        		"CREATE TABLE platforms (" +
            		"id INT GENERATED ALWAYS AS IDENTITY," +
            		"name VARCHAR2(100) NOT NULL," +
            		"PRIMARY KEY(id)" +
        		")"
    		);
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}