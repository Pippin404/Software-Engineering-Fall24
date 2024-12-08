package apis.ds;

import inputoutput.Delimiter;
import inputoutput.InputConfig;
import inputoutput.InputType;
import statuscodes.ParameterResponseCode;
import statuscodes.FileResponseCode;

import java.io.File;
import java.io.FileNotFoundException;

public class FileParseRequest {
//    should include an input config with the file path and the delimiters
    private Delimiter delimiter;
    private InputConfig inputConfig;
    private File inputFile;
    private InputType inputType;

    public Delimiter getDelimiter() {
        return delimiter;
    }

    public File getInputFile() {
        return inputFile;
    }

    public InputType getInputType() {
        return inputType;
    }

    public InputConfig getInputConfig() {
        return inputConfig;
    }


    public static Builder builder() {
        return new Builder();
    }

    private FileParseRequest(Builder builder) {
        this.inputFile = builder.inputFile;
        this.inputType = builder.inputType;
        this.delimiter = builder.delimiter;
    }

    public static class Builder {
        private Delimiter delimiter;
        private InputConfig inputConfig;
        private File inputFile;
        private InputType inputType;

        public Builder delimiter(Delimiter delimiter) {
            if (delimiter == null) {
                throw new IllegalArgumentException("Delimiter type cannot be null.");
            }
            this.delimiter = delimiter;
            return this;
        }

        public Builder inputFile(File inputFile) {
            if (inputFile == null) {
                throw new IllegalArgumentException("Input file cannot be null.");
            } else if (!inputFile.exists()) {
                throw new IllegalArgumentException("Invalid input file. File path: " + inputFile.getAbsolutePath());
            }
            this.inputFile = inputFile;
            return this;
        }

        public Builder inputType(InputType inputType) {
            if (inputType == null) {
                throw new IllegalArgumentException("Input type cannot be null.");
            }
            this.inputType = inputType;
            return this;
        }

        public FileParseRequest build() {
            if (delimiter == null) {
                throw new IllegalStateException("Delimiter is required.");
            } else if (inputFile == null) {
                throw new IllegalStateException("Input file is required.");
            } else if (inputType == null) {
                throw new IllegalStateException("Input type is required.");
            }
            return new FileParseRequest(this);
        }

    }

}
