package inputoutput;

import statuscodes.ParameterResponseCode;
import statuscodes.FileResponseCode;

public class OutputConfig {
//    this is necessary so the request to write to files doesn't need a million different variables
//    also makes it so we can expand the requests without breaking old constructors
    private String outputPath;
    private OutputType outputType;

    private ParameterResponseCode parameterResponseCode;
    private FileResponseCode fileResponseCode;


    public OutputConfig(String outputPath, OutputType outputType) {
//        TODO: Check if the output path is valid
        try {
            if(outputPath == null) {
                parameterResponseCode = ParameterResponseCode.NULL_PARAMETER;
                throw new IllegalArgumentException("Output path cannot be null.");
            } else {
                this.outputPath = outputPath;
            }

            if(outputType != null) {
                this.outputType = outputType;
            } else {
                parameterResponseCode = ParameterResponseCode.NULL_PARAMETER;
                throw new IllegalArgumentException("Output type cannot be null.");
            }
            parameterResponseCode = ParameterResponseCode.VALID_PARAMETERS;

        } catch(IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public String getOutputPath() {
        return outputPath;
    }

    public OutputType getOutputType() {
        return outputType;
    }

    public ParameterResponseCode getBasicResponseCode() {
        return parameterResponseCode;
    }

    public FileResponseCode getFileResponseCode() {
        return fileResponseCode;
    }
}
