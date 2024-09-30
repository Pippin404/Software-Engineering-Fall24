package inputoutput;

public enum Delimiter {
    COMMA(","),
    SEMICOLON(";"),
    TAB("\t"),
    PIPE("|");

    private final String value;

    Delimiter(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}