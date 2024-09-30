package apis.ds;

import inputoutput.OutputType;

import java.io.File;

public class OutputConfig {
//    this is necessary so the request to write to files doesn't need a million different variables
//    also makes it so we can expand the requests without breaking old constructors
    private final File OUTPUT_FILE;
    private final OutputType OUTPUT_TYPE;


    public OutputConfig(File OUTPUT_FILE, OutputType OUTPUT_TYPE) {
        this.OUTPUT_FILE = OUTPUT_FILE;
        this.OUTPUT_TYPE = OUTPUT_TYPE;
    }

    public File getOUTPUT_FILE() {
        return OUTPUT_FILE;
    }

    public OutputType getOUTPUT_TYPE() {
        return OUTPUT_TYPE;
    }
}
