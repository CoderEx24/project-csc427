package modular.design.studio;

public class Style {
    private final String font;
    private final String color;
    private final int size;

    public Style(String font, String color, int size) {
        this.font = font;
        this.color = color;
        this.size = size;
    }

    public String getFont() {
        return font;
    }

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Style{font='" + font + "', color='" + color + "', size=" + size + "}";
    }
}