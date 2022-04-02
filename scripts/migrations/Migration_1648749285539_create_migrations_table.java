import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Migration_1648749285539_create_migrations_table{
    public static void run() {
        Connection con = Migrate.getConnection();
        try {
            Statement stmt = con.createStatement();
            stmt.execute(
        		"CREATE TABLE migrations (" +
            		"id INT GENERATED ALWAYS AS IDENTITY," +
            		"migration VARCHAR2(100) NOT NULL" +
        		")"
    		);
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}