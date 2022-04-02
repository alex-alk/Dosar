import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Migrate {
	private static Connection connection;
	
    public static void main(String[] args) {
    	
    	if (args.length == 2) {
    		if (args[0].equals("make")) {
    			System.out.println("Creating migration file...");
    			String name = "Migration_" + System.currentTimeMillis() + "_" + args[1];
    			if(createFile(name)) {
    				writeToFile(name);
    			}
    		} else {
    			System.out.println("The first argument should be 'make'");
    		}
    	} else {
    		if (args.length == 1 && args[0].equals("migrate")) {
    			System.out.println("Migrating...");
    			setConnection();
    			String[] classNames = getFileNames();
	        	List<String> migrations = getMigrations();
    	        for (var className : classNames) {
    	        	className = className.substring(0, className.length() - 5);
    	        	if (!className.equals("compile-a") && !className.substring(className.length() - 1).equals(".")) {
        	        	if (!migrations.contains(className)) {
        	        		try {
            	        		Class<?> clazz = Class.forName(className);
            	        		clazz.getMethod("run").invoke(null);
            	        		insertMigration(className);
            	        	} catch (Exception e) {
                                e.printStackTrace();
            	        	}
        	        	}
    	        	}
    	        }
    	        try {
        			connection.close();
        		} catch (SQLException e) {
        			e.printStackTrace();
        		}
    	        System.out.println("Migration finished");
    		} else {
    			System.out.println("Command not found");
    		}
    	}
    }
    
    private static String[] getFileNames() {
        File f = new File("migrations");
        return f.list();
    }
    
    private static boolean createFile(String name) {
    	boolean isCreated = false;
    	try {
			File file = new File("migrations/" + name + ".java");
			if (file.createNewFile()) {
				System.out.println("File created: " + file.getName());
				isCreated = true;
			} else {
				System.out.println("File already exists.");
			}
	    } catch (IOException e) {
	    	System.out.println("An error occurred.");
	    }
    	return isCreated;
    }
    private static void writeToFile(String name) {
    	try {
            FileWriter myWriter = new FileWriter("migrations/" + name + ".java");
            myWriter.write("import java.sql.Connection;" + "\n");
            myWriter.write("import java.sql.SQLException;" + "\n");
            myWriter.write("import java.sql.Statement;" + "\n\n");
            myWriter.write("public class " + name + "{\n");
            myWriter.write("    public static void run() {\n");
            myWriter.write("        Connection con = Migrate.getConnection();\n");
    		myWriter.write("        try {\n");
            myWriter.write("            Statement stmt = con.createStatement();\n");
            myWriter.write("            stmt.execute(\"\");\n");
            myWriter.write("            stmt.close();\n");
            myWriter.write("        } catch (Exception e) {\n");
            myWriter.write("            e.printStackTrace();\n");
            myWriter.write("        }\n");
            myWriter.write("    }\n");
            myWriter.write("}");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
    
    private static List<String> getMigrations() {
    	List<String> list = new ArrayList<>();
    	try {
        	Statement stmt = connection.createStatement();
        	stmt.execute("SELECT * from migrations");
        	ResultSet results = stmt.getResultSet();
        	while (results.next()) {
        		list.add(results.getString("migration"));
        	}
        	results.close();
        	stmt.close();
    	} catch(SQLException e) {
    	}
    	return list;
    }
    
    private static void insertMigration(String name) throws SQLException {
    	Statement stmt = connection.createStatement();
        stmt.execute(
    		"INSERT INTO migrations (migration) VALUES ('" + name +"')"
		);
        stmt.close();
    }
    
    public static void setConnection() {
        connection = null;
        try {
        	connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.6:1521/xepdb1", "dosar", "password");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static Connection getConnection() {
    	return connection;
    }
}