package statuscodes;

public enum BasicResponseCode {
    SUCCESS(true),
    FAILURE(false);
    private boolean success;

    private BasicResponseCode(boolean success) {
        this.success = success;
    }
    public boolean success() {
        return success;
    }
}