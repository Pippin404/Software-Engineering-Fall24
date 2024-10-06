package apis.ds;

import inputoutput.Delimiter;
import inputoutput.InputType;
import statuscodes.BasicResponseCode;
import statuscodes.FileResponseCode;

import java.io.File;
import java.io.FileNotFoundException;

public class ParseInputFileRequest  {
//    should include an input config with the file path and the delimiters
    private File inputFile;
    private Delimiter delimiter;
    private InputType inputType;

//    status codes for error handling
    private BasicResponseCode basicResponseCode;
    private FileResponseCode fileResponseCode;

    public File getInputFile() {
        return inputFile;
    }

    public Delimiter getDelimiter() {
        return delimiter;
    }

    public InputType getInputType() {
        return inputType;
    }

    public BasicResponseCode getBasicResponseCode() {
        return basicResponseCode;
    }

    public FileResponseCode getParseInputFileResponseCode() {
        return fileResponseCode;
    }

    public ParseInputFileRequest(File inputFile, InputType inputType, Delimiter delimiter) {
        try {
//            inputFile cannot point to an invalid directory
//            if we check for inputFile.exists() first it would have a null pointer problem
            if(inputFile == null) {
                basicResponseCode = BasicResponseCode.NULL_PARAMETER;
                throw new IllegalArgumentException("Input file cannot be null.");
            }
            else if(inputFile.exists()) {
                fileResponseCode = FileResponseCode.VALID_FILE;
                this.inputFile = inputFile;
            } else {
                fileResponseCode = FileResponseCode.INVALID_FILE;
                throw new FileNotFoundException("Input file not found. File Path: " + inputFile);
            }

//            inputType cannot be null
            if(inputType != null) {
                this.inputType = inputType;
            } else {
                throw new IllegalArgumentException("Input type cannot be null.");
            }
//            delimiter cannot be null
            if(delimiter != null) {
                this.delimiter = delimiter;
            } else {
                basicResponseCode = BasicResponseCode.NULL_PARAMETER;
                throw new IllegalArgumentException("Delimiter type cannot be null.");
            }
            basicResponseCode = BasicResponseCode.VALID_PARAMETERS;

        } catch(FileNotFoundException e) {
            System.out.println("ParseInputFileCodes: " + this.fileResponseCode);
            e.printStackTrace();
        } catch(IllegalArgumentException e) {
            e.printStackTrace();
        }
        this.inputFile = inputFile;
        this.inputType = inputType;
        this.delimiter = delimiter;
    }

}
