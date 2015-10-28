import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Decryption extends FileEncryptor{
	
	protected String finishMessage;
	protected String filePostfix;
	
	public Decryption (EncryptionAlgorithm eAlgo, 
					   String finishMessage, String filePostfix) {
		super(eAlgo);
		this.finishMessage = finishMessage;
		this.filePostfix = filePostfix;
	}
	
	public int doAction(int value) {
		return super.eAlgo.singleDecryption(value);
	}
	
	public void makeKeyFile(String outputFileDir) {
		return;
	}
	
	public String getFilePostfix(){
		return this.filePostfix;
	}
	
	public String getFinishMessage() {
		return this.finishMessage;
	}


	public int getNewKeyValue(String path) {
		int key = -1;
		try {
			Scanner in = new Scanner(new FileReader(path));
			key = in.nextInt();
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Key file not found.");
			System.exit(0);
		} catch (InputMismatchException e) {
			System.out.println("The key file is faulty.");
			System.exit(0);
		}
		return key;
	}
}
