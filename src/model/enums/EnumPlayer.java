package model.enums;

public enum EnumPlayer {
    HUMAN('X'),
    AI('O');

    private final char value;

    private EnumPlayer(char value) {
        this.value = value;
    }

    public String getKey() {
        return this.name();
    }

    public char getValue() {
        return value;
    }

}
