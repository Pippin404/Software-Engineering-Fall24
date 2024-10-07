package statuscodes;

public enum ParameterResponseCode implements Success {
    VALID_PARAMETERS(true),
    NULL_PARAMETER(false);
    private boolean success;

    private ParameterResponseCode(boolean success) {
        this.success = success;
    }
    public boolean success() {
        return success;
    }

}
