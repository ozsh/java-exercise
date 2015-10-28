
public class XorEncryption implements EncryptionAlgorithm {

	private int key;
	
	public XorEncryption(int key) {
		this.key = key;
	}
	
	public int singleEncryption(int value) {
		return value^key;
	}

	public int singleDecryption(int value) {
	//Can not be implemented because xor is not injective function.
		return -1;
	}

	public void setKey(int newKey) {
		this.key = newKey;
	}

	public int getKey() {
		return this.key;
	}

	public int getKeyStrength() {
		return -1; 
	}

}