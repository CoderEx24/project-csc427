package modular.design.studio;

public interface UIBuilder {
    UIBuilder setTheme(String theme);
    UIBuilder addComponent(String componentType);
    Panel build();
}