package nl.lucemans.NovaItems;

public enum NBlockColor {

    CLEAR(0),
    ORANGE(1),
    MAGENTA(2),
    LIGHTBLUE(3),
    YELLOW(4),
    LIME(5),
    PINK(6),
    GRAY(7),
    LIGHTGRAY(8),
    CYAN(9),
    PURPLE(10),
    BLUE(11),
    BROWN(12),
    GREEN(13),
    RED(14),
    BLACK(15);

    private final int value;

    NBlockColor(final int value) {
        this.value = value;
    }

    public int getValue() { return value; }
}
