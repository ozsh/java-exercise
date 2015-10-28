import java.util.Random;


public class DoubleEncryption implements EncryptionAlgorithm {
	private EncryptionAlgorithm encryptionAlgorithm;
	private int maxRandNum;
	private int minRandNum;
	
	public DoubleEncryption(EncryptionAlgorithm encryptionAlgorithm,
			                int maxRandNum, int minRandNum) {
		this.encryptionAlgorithm = encryptionAlgorithm;
		this.maxRandNum = maxRandNum;
		this.minRandNum = minRandNum;
	}

	public int singleEncryption(int value) {
		int res = encryptionAlgorithm.singleEncryption(value);
		setRandomKey();
		res = encryptionAlgorithm.singleEncryption(res);
		setRandomKey();
		return res;
	}

	public int singleDecryption(int value) {
		//Can not be implemented because the randomize of the key.
		return -1;
	}

	public void setKey(int newKey) {
		this.encryptionAlgorithm.setKey(newKey);
	}

	public int getKey() {
		return this.encryptionAlgorithm.getKey();
	}
	
	private void setRandomKey(){
		Random random = new Random();
    	int randomKey = random.nextInt(maxRandNum - minRandNum + 1)
                        + minRandNum; 
    	encryptionAlgorithm.setKey(randomKey);
	}

	public int getKeyStrength() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
