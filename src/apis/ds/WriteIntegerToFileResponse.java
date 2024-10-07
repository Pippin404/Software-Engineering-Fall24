package apis.ds;

import statuscodes.BasicResponseCode;
import statuscodes.ParameterResponseCode;

public class WriteIntegerToFileResponse {
    private ParameterResponseCode parameterResponseCode;
    private BasicResponseCode basicResponseCode;

    public WriteIntegerToFileResponse(BasicResponseCode basicResponseCode) {
        try {
            if (parameterResponseCode == null) {
                parameterResponseCode = ParameterResponseCode.NULL_PARAMETER;
                throw new IllegalArgumentException("Response code cannot be null, try success or failure.");

            } else {
                this.basicResponseCode = basicResponseCode;
            }
        } catch(IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public ParameterResponseCode getBasicResponseCode() {
        return parameterResponseCode;
    }
}
