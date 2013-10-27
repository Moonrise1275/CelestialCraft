package moonrise.celestialcraft.exception;

import java.io.File;

public class InvalidFileException extends Exception {
	
	private File file;
	
	public InvalidFileException(File file) {
		super("Input file is invalid. Please check the file");
		this.file = file;
	}
	
	public File checkInvalidFile() {
		return file;
	}

}
