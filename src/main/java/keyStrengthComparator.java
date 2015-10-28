import java.util.Comparator;

public class keyStrengthComparator implements Comparator<EncryptionAlgorithm> {

	public int compare(EncryptionAlgorithm eAlgo1, EncryptionAlgorithm eAlgo2) {
		int keyStr1 = eAlgo1.getKeyStrength();  
		int keyStr2 = eAlgo2.getKeyStrength();
		return keyStr1 < keyStr2 ? -1 : keyStr1 == keyStr2 ? 0 : 1;
	}
}
