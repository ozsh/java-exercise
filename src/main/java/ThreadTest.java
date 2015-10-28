import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class ThreadTest {
	final static int NUM_OF_FILES = 10;
	final static int RAND_STR_LEN = 4;
	final static String TXT = "txt";
	final static int MAX_RND_NUM = 10;
	final static int MIN_RND_NUM = 1;
	final static String CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
	final static String encryptionFilePostfix = "_encrypted";
	final static String decryptionFilePostfix = "_decrypted";
	final static String encryptionFinighMessage = "The location of" +
					     " the encrypted file and the key file is: ";
	final static String decryptionFinighMessage = 
			               "The location of the deceypted file is: ";

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random r = new Random();
		FileEncryptor fEncryptor = null;
		IDirectoryProcessor DirEncryption = null;
		AsyncDirectoryProcessor AsyncDirHandler = null;
		SyncDirectoryProcessor SyncDirHandler = null;
		String randString = null;
		String path = null;
		long startTime = -1;
		long endTime = -1;
		long syncTime = -1;
		long asyncTime = -1;
		EncryptionAlgorithm eAlgo = new ShiftUpEncryption(-1);
		System.out.println("Enter the dir path to create files.");
		path = in.next();
		for(int i = 0; i < NUM_OF_FILES; i++){
			randString = generateString(r, CHARACTERS ,RAND_STR_LEN);
			try {
	            RandomAccessFile f = new RandomAccessFile(path + randString + TXT, "rw");
	            f.setLength(1024 * 1024 * 3);
	       } catch (Exception e) {
	            System.err.println(e);
	       }
		}
		
		fEncryptor = new Encryption(eAlgo, //ITS SOUNLD BE DOUBLE AGLO!
		   	    encryptionFinighMessage, encryptionFilePostfix,
			    MAX_RND_NUM, MIN_RND_NUM, false);
	    DirEncryption = new DirEncryption();
	    AsyncDirHandler = new AsyncDirectoryProcessor(fEncryptor, DirEncryption);
	    startTime = System.currentTimeMillis();
	    AsyncDirHandler.handleDir(path);
		endTime = System.currentTimeMillis();
		asyncTime = endTime - startTime;
		
		SyncDirHandler = new SyncDirectoryProcessor(fEncryptor, DirEncryption);
	    startTime = System.currentTimeMillis();
	    SyncDirHandler.handleDir(path);
		endTime = System.currentTimeMillis();
		syncTime = endTime - startTime;
		System.out.println("Sync time: " + syncTime +"\nAsync time: " + asyncTime);
		in.close();
	}

	public static String generateString(Random r, String characters, int length) {
	    char[] text = new char[length];
	    for (int i = 0; i < length; i++) {
	        text[i] = characters.charAt(r.nextInt(characters.length()));
	    }
	    return new String(text);
	}
	
}



