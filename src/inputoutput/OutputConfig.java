package inputoutput;

import java.io.File;
import java.nio.file.Path;

public class OutputConfig {
//    this is necessary so the request to write to files doesn't need a million different variables
//    also makes it so we can expand the requests without breaking old constructors
    private final String OUTPUT_FILE_NAME;
    private final Path OUTPUT_PATH;
    private final OutputType OUTPUT_TYPE;


    public OutputConfig(String OUTPUT_FILE_NAME, Path OUTPUT_PATH, OutputType OUTPUT_TYPE) {
        this.OUTPUT_FILE_NAME = OUTPUT_FILE_NAME;
        this.OUTPUT_TYPE = OUTPUT_TYPE;
        this.OUTPUT_PATH = OUTPUT_PATH;
    }

    public String getOUTPUT_FILE_NAME() {
        return OUTPUT_FILE_NAME;
    }

    public OutputType getOUTPUT_TYPE() {
        return OUTPUT_TYPE;
    }
}
