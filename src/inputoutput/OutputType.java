package inputoutput;

public enum OutputType {
//    done like this to make it easier to have case Strings on switch statements
    CONSOLE("CONSOLE"),
    CSV("CSV"),
    TEXT("TEXT"),
    JSON("JSON");

    private final String value;

    OutputType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
