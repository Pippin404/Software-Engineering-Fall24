package apis.ds;

import inputoutput.Delimiter;
import inputoutput.InputType;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParseInputFileRequest  {
//    should include an input config with the file path and the delimiters
    private File inputFile;
    private Delimiter delimiter;
    private InputType inputType;

    public File getInputFile() {
        return inputFile;
    }

    public Delimiter getDelimiter() {
        return delimiter;
    }

    public InputType getInputType() {
        return inputType;
    }

    public ParseInputFileRequest(File inputFile, InputType inputType, Delimiter delimiter) {
        this.inputFile = inputFile;
        this.inputType = inputType;
        this.delimiter = delimiter;
    }

}
