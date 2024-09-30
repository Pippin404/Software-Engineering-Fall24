package inputoutput;

public class OutputConfig {
//    this is necessary so the request to write to files doesn't need a million different variables
//    also makes it so we can expand the requests without breaking old constructors
    private final String outputPath;
    private final OutputType outputType;


    public OutputConfig(String outputPath, OutputType outputType) {
        this.outputPath = outputPath;
        this.outputType = outputType;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public OutputType getOutputType() {
        return outputType;
    }
}
