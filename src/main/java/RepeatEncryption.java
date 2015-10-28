
public class RepeatEncryption implements EncryptionAlgorithm{

	private EncryptionAlgorithm eAlgo;
	private int repeats;
	
	public RepeatEncryption(EncryptionAlgorithm eAlgo, int repeats) {
		this.eAlgo = eAlgo;
		this.repeats = repeats;
	}
	
	public int singleEncryption(int value) {
		int result = value;
		for (int i = 0; i < repeats; i++) {
			result = eAlgo.singleEncryption(result);
		}
		return result;
	}

    public int singleDecryption(int value) {
		int result = value;
		for (int i = 0; i < repeats; i++) {
			result = eAlgo.singleDecryption(result);
		}
		return result;
	}

	public void setKey(int newKey) {
		this.eAlgo.setKey(newKey);
	}

	public int getKey() {
		return this.eAlgo.getKey();
	}

	public int getKeyStrength() {
		// TODO Auto-generated method stub
		return 0;
	}

}
