package apis.ds;

import statuscodes.BasicResponseCode;
import statuscodes.ParameterResponseCode;

public class InternalWriteIntegerResponse {
    private ParameterResponseCode parameterResponseCode;
    private BasicResponseCode basicResponseCode;

    public InternalWriteIntegerResponse(BasicResponseCode basicResponseCode) {
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

    public BasicResponseCode getBasicResponseCode() {
        return basicResponseCode;
    }
}
