import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class Encryption extends FileEncryptor{
	
	protected String finishMessage;
	protected String filePostfix;
	protected int maxRandNum;
	protected int minRandNum;
	protected boolean isRandKey;
    	
    public Encryption (EncryptionAlgorithm eAlgo, 
                       String finishMessage, String filePostfix,
                       int maxRandNum, int minRandNum,
                       boolean isRandKey) {
    	super(eAlgo);
		this.finishMessage = finishMessage;
		this.filePostfix = filePostfix;
		this.maxRandNum = maxRandNum;
		this.minRandNum = minRandNum;
	    this.isRandKey = isRandKey;
	    if (!isRandKey){
			Random random = new Random();
			int key = random.nextInt(maxRandNum - minRandNum + 1)
	                + minRandNum; 
		   	super.setKey(key);
	    }
    }
    
	public int doAction(int value) {
		return super.eAlgo.singleEncryption(value);
	}
	
	public void makeKeyFile(String outputFileDir) {
		FileWriter keyFileStream = null;
		try {
			keyFileStream = new FileWriter(outputFileDir + "key");
	        keyFileStream.write(new Integer(super.getAlgoKey()).toString());
	        keyFileStream.close();	
		} catch (IOException e) {
			System.out.println("Key file not found.");
		}
	}
	
	public int getNewKeyValue(String path) {
		if (isRandKey){
			Random random = new Random();
		   	return random.nextInt(maxRandNum - minRandNum + 1)
	                + minRandNum; 
		} else {
			return super.getAlgoKey();
		}
	}
	
	public String getFilePostfix(){
		return this.filePostfix;
	}
	
	public String getFinishMessage() {
		return this.finishMessage;
	}


}
