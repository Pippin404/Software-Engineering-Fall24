package apis.ds;

import statuscodes.ParameterResponseCode;

public class WriteListToFileResponse {
    private ParameterResponseCode parameterResponseCode;

    public WriteListToFileResponse(ParameterResponseCode parameterResponseCode) {
        this.parameterResponseCode = parameterResponseCode;
    }

    public ParameterResponseCode getBasicResponseCode() {
        return parameterResponseCode;
    }
}
