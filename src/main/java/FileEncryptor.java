
public abstract class FileEncryptor {
	
	protected EncryptionAlgorithm eAlgo;

	public FileEncryptor(EncryptionAlgorithm eAlgo){
		this.eAlgo = eAlgo;
	}
	
    public int getAlgoKey() {
    	return this.eAlgo.getKey();
    }
    
	public void setKey(int newKey){
		this.eAlgo.setKey(newKey);
	}
	
	public long actionStarted() {
		return System.currentTimeMillis();
	}

    
	public abstract int doAction(int value);
	public abstract void makeKeyFile(String outputFileDir);
	public abstract int getNewKeyValue(String path);
	public abstract String getFilePostfix();
	public abstract String getFinishMessage();
}
