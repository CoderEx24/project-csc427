package modular.design.studio;

public class ComponentFactory {
    public static UIComponent createComponent(String type, Style style) {
        switch (type.toLowerCase()) {
            case "button":
                return new Button(style);
            case "textbox":
                return new Textbox(style);
            case "dropdown":
                return new Dropdown(style);
            default:
                throw new IllegalArgumentException("Unknown component type: " + type);
        }
    }
}