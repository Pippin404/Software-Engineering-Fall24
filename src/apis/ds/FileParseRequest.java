package apis.ds;

import inputoutput.Delimiter;
import inputoutput.InputConfig;
import statuscodes.ParameterResponseCode;
import statuscodes.FileResponseCode;

public class FileParseRequest {
//    should include an input config with the file path and the delimiters
    private Delimiter delimiter;
    private InputConfig inputConfig;

//    status codes for error handling
    private ParameterResponseCode parameterResponseCode;
    private FileResponseCode fileResponseCode;

    public Delimiter getDelimiter() {
        return delimiter;
    }

    public InputConfig getInputConfig() {
        return inputConfig;
    }

    public ParameterResponseCode getBasicResponseCode() {
        return parameterResponseCode;
    }

    public FileResponseCode getParseInputFileResponseCode() {
        return fileResponseCode;
    }

    public FileParseRequest(InputConfig inputConfig, Delimiter delimiter) {
        try {
            if (inputConfig == null) {
                parameterResponseCode = ParameterResponseCode.NULL_PARAMETER;
                throw new IllegalArgumentException("Input config cannot be null.");
            } else {
                this.inputConfig = inputConfig;
            }

//            delimiter cannot be null
            if (delimiter != null) {
                this.delimiter = delimiter;
            } else {
                parameterResponseCode = ParameterResponseCode.NULL_PARAMETER;
                throw new IllegalArgumentException("Delimiter type cannot be null.");
            }
            parameterResponseCode = ParameterResponseCode.VALID_PARAMETERS;

        } catch(IllegalArgumentException e) {
            e.printStackTrace();
        }

    }

}
