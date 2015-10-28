import java.io.File;
import java.util.Scanner;

public class Main {
	final static int MAX_RND_NUM = 10;
	final static int MIN_RND_NUM = 1;
	final static String encryptionFilePostfix = "_encrypted";
	final static String decryptionFilePostfix = "_decrypted";
	final static String encryptionFinighMessage = "The location of" +
					     " the encrypted file and the key file is: ";
	final static String decryptionFinighMessage = 
			               "The location of the deceypted file is: ";
	
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int menuSelection = -1;
    	String inputPath = "";
    	FileEncryptor fEncryptor = null;
    	EncryptionAlgorithm eAlgo = null;
    	EncryptionAlgorithm doubleAlgo = null;
    	AsyncDirectoryProcessor dirHandler = null;
    	FileHandler fileHandler = null;
    	IDirectoryProcessor DirEncryption = null;
    	eAlgo = new ShiftUpEncryption(-1);
    	doubleAlgo = new DoubleEncryption(eAlgo, MAX_RND_NUM, 
                                         MIN_RND_NUM);
        System.out.println("Hello! Please select an option:");
        System.out.println("1. Encryption single file.");
        System.out.println("2. Decryption single file.");
        System.out.println("3. Encryption whole directory.");
        System.out.println("4. Decryption whole directory.");
        menuSelection = in.nextInt();
    	System.out.println("Enter path:");
    	inputPath = in.next();
    	switch (menuSelection) {
    	case 1:
    	case 2:
    		if (menuSelection == 1) {
    			fEncryptor = new Encryption(eAlgo, //ITS SOUNLD BE DOUBLE AGLO!
        			encryptionFinighMessage, encryptionFilePostfix,
        			MAX_RND_NUM, MIN_RND_NUM, false);
    		} else {
    			fEncryptor = new Decryption(eAlgo, //ITS SOUNLD BE DOUBLE AGLO!
            			decryptionFinighMessage, decryptionFilePostfix);    			
    		}
            fileHandler = new FileHandler(fEncryptor);
            fileHandler.handleFile(inputPath, inputPath+fEncryptor.getFilePostfix());
            break;

    	case 3:
    	case 4:
            if (menuSelection == 3){
    		    fEncryptor = new Encryption(eAlgo, //ITS SOUNLD BE DOUBLE AGLO!
        		   	    encryptionFinighMessage, encryptionFilePostfix,
        			    MAX_RND_NUM, MIN_RND_NUM, false);
    		    DirEncryption = new DirEncryption();
            } else {
        		fEncryptor = new Decryption(eAlgo, //ITS SOUNLD BE DOUBLE AGLO!
        				decryptionFinighMessage, decryptionFilePostfix);
        		DirEncryption = new DirDecryption();
            }
    	  
    		dirHandler = new AsyncDirectoryProcessor(fEncryptor, DirEncryption);
    		dirHandler.handleDir(inputPath);
    		break;
    		
    		
    	default:         
    	    System.out.println("Wrong input.");
    	}
        in.close();
    }
}
