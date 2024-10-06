package inputoutput;

import statuscodes.ParameterResponseCode;
import statuscodes.FileResponseCode;

import java.io.File;
import java.io.FileNotFoundException;

public class InputConfig {
//        the logic in ParseInputFileRequest just got a little cluttered, so I seperated this into its own file
    private File inputFile;
    private InputType inputType;

    private ParameterResponseCode parameterResponseCode;
    private FileResponseCode fileResponseCode;

    public InputConfig(File inputFile, InputType inputType) {
        try {
//            check in this order because if it's null, and you call inputFile.exists() it could cause a null pointer problem before reaching the other checks
            if(inputFile == null) {
                parameterResponseCode = ParameterResponseCode.NULL_PARAMETER;
                throw new IllegalArgumentException("Input file cannot be null.");
            } else if(inputFile.exists()) {
                fileResponseCode = FileResponseCode.VALID_FILE;
                this.inputFile = inputFile;
            } else {
                fileResponseCode = FileResponseCode.INVALID_FILE;
                throw new FileNotFoundException("Invalid input file. File path: " + inputFile.getAbsolutePath());
            }

            if (inputType == null) {
                parameterResponseCode = ParameterResponseCode.NULL_PARAMETER;
                throw new IllegalArgumentException("Input type cannot be null.");
            } else {
                this.inputType = inputType;
            }

        } catch(FileNotFoundException e) {
            System.out.println("ParseInputFileCodes: " + this.fileResponseCode);
            e.printStackTrace();
        } catch(IllegalArgumentException e) {
            e.printStackTrace();
        }

    }

    public File getInputFile() {
        return inputFile;
    }

    public InputType getInputType() {
        return inputType;
    }

    public ParameterResponseCode getBasicResponseCode() {
        return parameterResponseCode;
    }

    public FileResponseCode getFileResponseCode() {
        return fileResponseCode;
    }
}
