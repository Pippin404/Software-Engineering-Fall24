package statuscodes;

public enum BasicResponseCode {
    SUCCESS(true),
    FAILURE(false),
    VALID_PARAMETERS(true),
    NULL_PARAMETER(false);
    private boolean success;

    private BasicResponseCode(boolean success) {
        this.success = success;
    }
    public boolean success() {
        return success;
    }

}
