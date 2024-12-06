package apis.ds;

import inputoutput.OutputConfig;
import inputoutput.OutputType;
import statuscodes.ParameterResponseCode;

public class InternalWriteIntegerRequest {
    private String outputPath;
    private OutputType outputType;
    private int computedInteger;

    private InternalWriteIntegerRequest(Builder builder) {
        this.outputPath = builder.outputPath;
        this.outputType = builder.outputType;
        this.computedInteger = builder.computedInteger;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public OutputType getOutputType() {
        return outputType;
    }

    public int getComputedInteger() {
        return computedInteger;
    }
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String outputPath;
        private OutputType outputType;
        private int computedInteger;

        public Builder outputPath(String outputPath) {
            if (outputPath == null || outputPath.trim().isEmpty()) {
                throw new IllegalArgumentException("Output path cannot be null or empty.");
            } else {
                this.outputPath = outputPath;
            }
            return this;
        }

        public Builder outputType(OutputType outputType) {
            if (outputType == null) {
                throw new IllegalArgumentException("Output type cannot be null.");
            } else {
                this.outputType = outputType;
            }
            return this;
        }

        public Builder computedInteger(int computedInteger) {
            this.computedInteger = computedInteger;
            return this;
        }

        public InternalWriteIntegerRequest build() {
            if (outputType == null) {
                throw new IllegalArgumentException("Output type cannot be null.");
            }
            else if (outputPath == null || outputPath.trim().isEmpty()) {
                throw new IllegalArgumentException("Output path cannot be null or empty.");
            }
            return new InternalWriteIntegerRequest(this);
        }
    }
}
