import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileHandler {
	
	private FileEncryptor fe;
	
	public FileHandler (FileEncryptor fe) {
		this.fe = fe;
		
	}
	
	public void handleFile(String inputFilePath, String outputFilePath) {

    	FileReader inputStream = null;
    	FileWriter outputStream = null;
    	int c = -1;
    	String inputFileDir = findPath(inputFilePath);
    	String outputFileDir = findPath(outputFilePath);
    	int key = this.fe.getNewKeyValue(inputFileDir + "key");
    	this.fe.setKey(key);
        try {
            inputStream = new FileReader(inputFilePath);
            this.fe.makeKeyFile(outputFileDir);
            outputStream = new FileWriter(outputFilePath);
            while ((c = inputStream.read()) != -1) {
            	outputStream.write(fe.doAction(c));
            }
        } catch (IOException e) {
        	System.out.println("Illegal file path");
        	System.exit(0);
        }
        
        finally {
            if (inputStream != null) {
                try {
					inputStream.close();
				} catch (IOException e) {
		        	System.out.println("Something went worng..");
		        	System.exit(0);
				}
            }
            if (outputStream != null) {
                try {
					outputStream.close();
				} catch (IOException e) {
		        	System.out.println("Something went worng..");
		        	System.exit(0);
				}
            }
        }
    	System.out.println(fe.getFinishMessage() + outputFileDir);
	}
	
	
    private String findPath(String filePath) {
    	String path = "";
    	int lastBackslash = filePath.lastIndexOf(47);
    	path = filePath.substring(0, lastBackslash + 1);
    	return path;
    }
}
