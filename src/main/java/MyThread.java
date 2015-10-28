
public class MyThread implements Runnable {
	private FileHandler fileHandler;
	private String inputFile;
	private String outputFile;
	
    public MyThread(FileHandler fileHandler, String inputFile, String outputFile) {
	       this.fileHandler = fileHandler;
	       this.inputFile = inputFile;
	       this.outputFile = outputFile;
	}

    public void run() {
    	fileHandler.handleFile(inputFile, outputFile);
	}

}
