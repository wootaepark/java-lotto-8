package lotto.utils.constant;

public enum ErrorPrefix {
    ERROR("[ERROR] ");

    private final String prefix;

    private ErrorPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}
