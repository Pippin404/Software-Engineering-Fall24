package apis.ds;

import statuscodes.FileResponseCode;
import statuscodes.ParameterResponseCode;

public class InternalWriteIntegerResponse {
    private FileResponseCode fileResponseCode;

    private InternalWriteIntegerResponse(Builder builder) {
        this.fileResponseCode = builder.fileResponseCode;
    }

    public FileResponseCode getFileResponseCode() {
        return fileResponseCode;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private FileResponseCode fileResponseCode;

        public Builder fileResponseCode(FileResponseCode fileResponseCode) {
            if (fileResponseCode == null) {
                throw new IllegalArgumentException("File response code cannot be null.");
            }
            this.fileResponseCode = fileResponseCode;
            return this;
        }

        public InternalWriteIntegerResponse build() {
            if (fileResponseCode == null) {
                throw new IllegalStateException("File response code is required.");
            }
            return new InternalWriteIntegerResponse(this);
        }
    }
}