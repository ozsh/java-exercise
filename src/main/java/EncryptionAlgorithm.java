
public interface EncryptionAlgorithm {
	
	public int singleEncryption(int value);
	public int singleDecryption(int value);
	public void setKey(int newKey);
	public int getKey();
	public int getKeyStrength();
	
}