import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Migrate {
    public static void main(String[] args) {
    	
    	if (args.length == 2) {
    		if (args[0].equals("make")) {
    			System.out.println("Creating migration file...");
    			String name = args[1] + "_" +System.currentTimeMillis();
    			if(createFile(name)) {
    				writeToFile(name);
    			}
    		} else {
    			System.out.println("The first argument should be 'make'");
    		}
    	} else {
    		if (args.length == 1 && args[0].equals("migrate")) {
    			System.out.println("Migrating...");
    			String[] classNames = getFileNames();
    	        for (String className : classNames) {
    	        	className = className.substring(0, className.length() - 5);
    	        	if (!className.equals("compile-a") && !className.equals("Migrate") && !className.substring(className.length() - 1).equals(".")) {
        	        	try {
        	        		Class<?> clazz = Class.forName(className);
        	        		clazz.getMethod("run").invoke(null);
        	        	} catch (Exception e) {
        	        		e.printStackTrace();
        	        	}
    	        	}
    	        }
    	        System.out.println("Migration finished");
    		}
    	}
    }
    
    private static String[] getFileNames() {
        File f = new File(".");
        return f.list();
    }
    
    private static boolean createFile(String name) {
    	boolean isCreated = false;
    	try {
			File file = new File(name + ".java");
			if (file.createNewFile()) {
				System.out.println("File created: " + file.getName());
				isCreated = true;
			} else {
				System.out.println("File already exists.");
			}
	    } catch (IOException e) {
	    	System.out.println("An error occurred.");
	    	e.printStackTrace();
	    }
    	return isCreated;
    }
    private static void writeToFile(String name) {
    	try {
    		FileWriter myWriter = new FileWriter(name + ".java");
    		myWriter.write("public class " + name + "{\n");
    		myWriter.write("\tpublic static void run() {\n");
    		myWriter.write("\t\tString connection = Migrate.getConnection();\n");
    		myWriter.write("\t\tSystem.out.println(connection);\n");
    		myWriter.write("\t}\n");
    		myWriter.write("}");
    		myWriter.close();
    		System.out.println("Successfully wrote to the file.");
	    } catch (IOException e) {
	    	System.out.println("An error occurred.");
	    	e.printStackTrace();
	    }
    }
    
    public static String getConnection() {
    	return "the connection";
    }
}