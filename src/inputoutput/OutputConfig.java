package inputoutput;

import java.io.File;
import java.nio.file.Path;

public class OutputConfig {
//    this is necessary so the request to write to files doesn't need a million different variables
//    also makes it so we can expand the requests without breaking old constructors
    private final String OUTPUT_PATH;
    private final OutputType OUTPUT_TYPE;


    public OutputConfig(String OUTPUT_PATH, OutputType OUTPUT_TYPE) {
        this.OUTPUT_PATH = OUTPUT_PATH;
        this.OUTPUT_TYPE = OUTPUT_TYPE;
    }

    public String getOUTPUT_PATH() {
        return OUTPUT_PATH;
    }

    public OutputType getOUTPUT_TYPE() {
        return OUTPUT_TYPE;
    }
}
