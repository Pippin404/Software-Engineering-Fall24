package apis.ds;

import statuscodes.BasicResponseCode;
import statuscodes.ParameterResponseCode;

public class WriteIntegerResponse {
    private ParameterResponseCode parameterResponseCode;
    private BasicResponseCode basicResponseCode;

    public WriteIntegerResponse(BasicResponseCode basicResponseCode) {
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
