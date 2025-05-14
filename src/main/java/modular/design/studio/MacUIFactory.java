package modular.design.studio;

public class MacUIFactory implements AbstractUIFactory {
    @Override
    public UIComponent createButton() {
        return new Button(StyleFactory.getStyle("Helvetica", "gray", 14));
    }

    @Override
    public UIComponent createTextbox() {
        return new Textbox(StyleFactory.getStyle("Helvetica", "white", 14));
    }

    @Override
    public UIComponent createDropdown() {
        return new Dropdown(StyleFactory.getStyle("Helvetica", "lightgray", 14));
    }
}