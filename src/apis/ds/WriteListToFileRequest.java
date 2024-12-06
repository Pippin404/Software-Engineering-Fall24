package apis.ds;

import inputoutput.OutputConfig;
import inputoutput.OutputType;
import statuscodes.ParameterResponseCode;

import java.util.List;

public class WriteListToFileRequest {
    private List<Integer> parsedIntegerList;
    private String outputPath;
    private OutputType outputType;
    private ParameterResponseCode parameterResponseCode;

    private WriteListToFileRequest(Builder builder) {
        this.parsedIntegerList = builder.parsedIntegerList;
        this.outputPath = builder.outputPath;
        this.outputType = builder.outputType;
        this.parameterResponseCode = builder.parameterResponseCode;
    }

    public List<Integer> getParsedIntegerList() {
        return parsedIntegerList;
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

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<Integer> parsedIntegerList;
        private String outputPath;
        private OutputType outputType;
        private ParameterResponseCode parameterResponseCode = ParameterResponseCode.VALID_PARAMETERS;

        public Builder parsedIntegerList(List<Integer> parsedIntegerList) {
            if (parsedIntegerList == null) {
                parameterResponseCode = ParameterResponseCode.NULL_PARAMETER;
                throw new IllegalArgumentException("List of integers cannot be null.");
            }
            this.parsedIntegerList = parsedIntegerList;
            return this;
        }

        public Builder outputPath(String outputPath) {
            if (outputPath == null || outputPath.isEmpty()) {
                parameterResponseCode = ParameterResponseCode.NULL_PARAMETER;
                throw new IllegalArgumentException("Output path cannot be null or empty.");
            }
            this.outputPath = outputPath;
            return this;
        }

        public Builder outputType(OutputType outputType) {
            if (outputType == null) {
                parameterResponseCode = ParameterResponseCode.NULL_PARAMETER;
                throw new IllegalArgumentException("Output type cannot be null.");
            }
            this.outputType = outputType;
            return this;
        }

        public WriteListToFileRequest build() {
            if (outputPath == null) {
                throw new IllegalStateException("outputPath is required.");
            }
            else if (outputType == null) {
                throw new IllegalArgumentException("Output type cannot be null.");
            }
            else if (parsedIntegerList == null) {
                throw new IllegalStateException("ParsedIntegerList is required.");
            }
            return new WriteListToFileRequest(this);
        }
    }
}