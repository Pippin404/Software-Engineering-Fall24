package apis.ds;

import statuscodes.ParameterResponseCode;
import statuscodes.FileResponseCode;

import java.util.List;

public class FileParseResponse {
    private List<Integer> parsedIntegers;
    private FileResponseCode fileResponseCode;
    private ParameterResponseCode parameterResponseCode;

    private FileParseResponse(List<Integer> parsedIntegers, FileResponseCode fileResponseCode, ParameterResponseCode parameterResponseCode) {
        this.parsedIntegers = parsedIntegers;
        this.fileResponseCode = fileResponseCode;
        this.parameterResponseCode = parameterResponseCode;
    }

    public List<Integer> getParsedIntegers() {
        return parsedIntegers;
    }

    public FileResponseCode getParseInputFileResponseCode() {
        return fileResponseCode;
    }

    public ParameterResponseCode getBasicResponseCode() {
        return parameterResponseCode;
    }

    // Builder class for FileParseResponse
    public static class Builder {
        private List<Integer> parsedIntegers;
        private FileResponseCode fileResponseCode;
        private ParameterResponseCode parameterResponseCode;

        public Builder parsedIntegers(List<Integer> parsedIntegers) {
            if (parsedIntegers == null) {
                throw new IllegalArgumentException("Parsed integers cannot be null.");
            }
            this.parsedIntegers = parsedIntegers;
            return this;
        }

        public Builder fileResponseCode(FileResponseCode fileResponseCode) {
            if (fileResponseCode == null) {
                throw new IllegalArgumentException("File response code cannot be null.");
            }
            this.fileResponseCode = fileResponseCode;
            return this;
        }

        public FileParseResponse build() {
            if (parsedIntegers == null) {
                throw new IllegalStateException("Parsed integers are required.");
            }
            if (fileResponseCode == null) {
                throw new IllegalStateException("File response code is required.");
            }
            return new FileParseResponse(parsedIntegers, fileResponseCode, parameterResponseCode);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}