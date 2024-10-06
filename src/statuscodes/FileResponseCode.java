package statuscodes;

public enum FileResponseCode implements Success {
    VALID_FILE(true),
    INVALID_FILE(false),
    VALID_PATH(true),
    INVALID_PATH(false);

    private boolean success;

    private FileResponseCode(boolean success) {
        this.success = success;
    }
    public boolean success() {
        return success;
    }
}
