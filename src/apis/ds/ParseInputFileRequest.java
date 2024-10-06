package apis.ds;

import inputoutput.Delimiter;
import inputoutput.InputConfig;
import statuscodes.BasicResponseCode;
import statuscodes.FileResponseCode;

public class ParseInputFileRequest  {
//    should include an input config with the file path and the delimiters
    private Delimiter delimiter;
    private InputConfig inputConfig;

//    status codes for error handling
    private BasicResponseCode basicResponseCode;
    private FileResponseCode fileResponseCode;

    public Delimiter getDelimiter() {
        return delimiter;
    }

    public InputConfig getInputConfig() {
        return inputConfig;
    }

    public BasicResponseCode getBasicResponseCode() {
        return basicResponseCode;
    }

    public FileResponseCode getParseInputFileResponseCode() {
        return fileResponseCode;
    }

    public ParseInputFileRequest(InputConfig inputConfig, Delimiter delimiter) {
        try {
            if (inputConfig == null) {
                basicResponseCode = BasicResponseCode.NULL_PARAMETER;
                throw new IllegalArgumentException("Input config cannot be null.");
            } else {
                this.inputConfig = inputConfig;
            }

//            delimiter cannot be null
            if (delimiter != null) {
                this.delimiter = delimiter;
            } else {
                basicResponseCode = BasicResponseCode.NULL_PARAMETER;
                throw new IllegalArgumentException("Delimiter type cannot be null.");
            }
            basicResponseCode = BasicResponseCode.VALID_PARAMETERS;

        } catch(IllegalArgumentException e) {
            e.printStackTrace();
        }

    }

}
