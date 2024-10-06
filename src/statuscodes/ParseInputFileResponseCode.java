package statuscodes;

public enum ParseInputFileResponseCode {
    VALID_FILE(true),
    INVALID_FILE(false);
    private boolean success;

    private ParseInputFileResponseCode(boolean success) {
        this.success = success;
    }
    public boolean success() {
        return success;
    }
}
