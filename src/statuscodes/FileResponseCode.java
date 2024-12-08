package statuscodes;

public enum FileResponseCode implements Success {
    VALID_FILE(true),
    INVALID_FILE(false),
    VALID_PATH(true),
    INVALID_PATH(false),
    INVALID_DELIMITERS(false),
    INTEGER_NOT_WRITTEN(false),
    INTEGER_WRITTEN(true);

    private boolean success;

    private FileResponseCode(boolean success) {
        this.success = success;
    }
    public boolean success() {
        return success;
    }
}
