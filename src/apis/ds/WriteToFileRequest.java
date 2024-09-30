package apis.ds;

import inputoutput.Delimiter;
import inputoutput.InputType;
import inputoutput.OutputType;

import java.io.File;
import java.util.List;

public class WriteToFileRequest {
    private final OutputConfig OUTPUT_CONFIG;

//    this way we can support both functionalities of writing the integers to the file as they are calculated, or writing them to the file all at once when the calculation is done
    private int singleParsedInteger;
    private List<Integer> parsedIntegerList;

    public WriteToFileRequest(OutputConfig OUTPUT_CONFIG, int singleParsedInteger) {
        this.OUTPUT_CONFIG = OUTPUT_CONFIG;
        this.singleParsedInteger = singleParsedInteger;
    }

    public WriteToFileRequest(OutputConfig OUTPUT_CONFIG, List<Integer> parsedIntegerList) {
        this.OUTPUT_CONFIG = OUTPUT_CONFIG;
        this.parsedIntegerList = parsedIntegerList;
    }
}
