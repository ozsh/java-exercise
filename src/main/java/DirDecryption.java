
public class DirDecryption implements IDirectoryProcessor{

	public String getOutputDir(String inputPath) {
		return findPath(inputPath);
	}

	public String getFinishMessage() {
		return "Decryption whole dir complate.";

	}
	
    private String findPath(String filePath) {
    	int lastBackslash = filePath.lastIndexOf(47);
    	String path = filePath.substring(0, lastBackslash);
    	lastBackslash = path.lastIndexOf(47);
    	path = filePath.substring(0, lastBackslash + 1);
    	return path;
    }
}
