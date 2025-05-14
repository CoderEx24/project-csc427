package modular.design.studio;

public class WindowsUIFactory implements AbstractUIFactory {
    @Override
    public UIComponent createButton() {
        return new Button(StyleFactory.getStyle("Arial", "blue", 12));
    }

    @Override
    public UIComponent createTextbox() {
        return new Textbox(StyleFactory.getStyle("Arial", "white", 12));
    }

    @Override
    public UIComponent createDropdown() {
        return new Dropdown(StyleFactory.getStyle("Arial", "lightblue", 12));
    }
}