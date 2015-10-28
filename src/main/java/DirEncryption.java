import java.io.File;


public class DirEncryption implements IDirectoryProcessor{

	public String getOutputDir(String inputPath) {
		String outputDir = inputPath + "encrypted/";
		new File(outputDir).mkdir();
		return outputDir;
	}

	public String getFinishMessage() {
		return "Encryption whole dir complate.";
	}

}
