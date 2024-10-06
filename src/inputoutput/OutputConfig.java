package inputoutput;

import statuscodes.BasicResponseCode;
import statuscodes.FileResponseCode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class OutputConfig {
//    this is necessary so the request to write to files doesn't need a million different variables
//    also makes it so we can expand the requests without breaking old constructors
    private String outputPath;
    private OutputType outputType;

    private BasicResponseCode basicResponseCode;
    private FileResponseCode fileResponseCode;


    public OutputConfig(String outputPath, OutputType outputType)
    {
//        TODO: Check if the output path is valid
        try {
            if(outputPath == null) {
                basicResponseCode = BasicResponseCode.NULL_PARAMETER;
                throw new IllegalArgumentException("Output path cannot be null.");
            } else {
                this.outputPath = outputPath;
            }

            if(outputType != null) {
                this.outputType = outputType;
            } else {
                basicResponseCode = BasicResponseCode.NULL_PARAMETER;
                throw new IllegalArgumentException("Output type cannot be null.");
            }
            basicResponseCode = BasicResponseCode.VALID_PARAMETERS;

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

    public BasicResponseCode getBasicResponseCode() {
        return basicResponseCode;
    }

    public FileResponseCode getFileResponseCode() {
        return fileResponseCode;
    }
}
