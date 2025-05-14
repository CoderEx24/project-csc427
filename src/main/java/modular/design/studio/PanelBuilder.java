package modular.design.studio;

public class PanelBuilder implements UIBuilder {
    private Panel panel;
    private AbstractUIFactory factory;

    public PanelBuilder() {
        this.panel = new Panel(StyleFactory.getStyle("Times", "lightgray", 16));
    }

    @Override
    public UIBuilder setTheme(String theme) {
        this.factory = ThemeManager.getInstance().getFactory(theme);
        return this;
    }

    @Override
    public UIBuilder addComponent(String componentType) {
        switch (componentType.toLowerCase()) {
            case "button":
                panel.addComponent(factory.createButton());
                break;
            case "textbox":
                panel.addComponent(factory.createTextbox());
                break;
            case "dropdown":
                panel.addComponent(factory.createDropdown());
                break;
            default:
                throw new IllegalArgumentException("Unknown component type: " + componentType);
        }
        return this;
    }

    @Override
    public Panel build() {
        return panel;
    }
}