package inputoutput;

public enum InputType {
    //    done like this to make it easier to have case Strings on switch statements
    CONSOLE("CONSOLE"),
    CSV("CSV"),
    TEXT("TEXT"),
    JSON("JSON");

    private final String value;

    InputType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
