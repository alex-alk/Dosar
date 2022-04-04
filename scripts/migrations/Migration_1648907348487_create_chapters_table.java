import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Migration_1648907348487_create_chapters_table{
    public static void run() {
        Connection con = Migrate.getConnection();
        try {
            Statement stmt = con.createStatement();
            stmt.execute(
        		"CREATE TABLE chapters (" +
            		"id NUMBER(10, 0) GENERATED ALWAYS AS IDENTITY," +
            		"name VARCHAR2(100) NOT NULL," +
    				"content CLOB NOT NULL," +
            		"platform_id NUMBER(10, 0) NOT NULL," +
            		"PRIMARY KEY(id)," +
            		"CONSTRAINT FK_chapters_PLATFORM_ID " +
            	    "FOREIGN KEY (platform_id) " +
            	    "REFERENCES platforms (id)" +
        		")"
    		);
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}