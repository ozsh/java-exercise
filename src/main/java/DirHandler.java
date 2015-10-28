import java.io.File;


public class DirHandler {
	private FileEncryptor fe;
	private IDirectoryProcessor dp;
	
	public DirHandler (FileEncryptor fe, IDirectoryProcessor dp) {
		this.fe = fe;
		this.dp = dp;
	}
	
	public void handleDir(String inputPath) {
		String inputFile = null;
		String outFile = null;
		FileHandler fileHandler = new FileHandler(fe);
		File folder = new File(inputPath);
		File[] listOfFiles = folder.listFiles();

		String outputDir = dp.getOutputDir(inputPath);

		for (int i = 0; i < listOfFiles.length; i++) {
		  File file = listOfFiles[i];
		  if (file.isFile() && file.getName().contains("txt")) {
			  inputFile = inputPath + file.getName();
			  outFile = outputDir + file.getName();
			  fileHandler.handleFile(inputFile, outFile);
		  }
		}
		System.out.println(dp.getFinishMessage());
	}
	
}

