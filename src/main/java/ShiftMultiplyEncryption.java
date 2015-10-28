
public class ShiftMultiplyEncryption implements EncryptionAlgorithm {

	private int key;
	
	public ShiftMultiplyEncryption(int key) {
		this.key = key;
	}
	
	public int singleEncryption(int value) {
		return value * this.key;
	}

	public int singleDecryption(int value) {
		return value / this.key;
	}

	public void setKey(int newKey) {
		this.key = newKey;
	}

	public int getKey() {
		return this.key;
	}

	public int getKeyStrength() {
		// TODO Auto-generated method stub
		return 0;
	}

}