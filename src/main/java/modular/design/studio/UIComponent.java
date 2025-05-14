package modular.design.studio;

import javafx.scene.layout.Pane;

public interface UIComponent extends Cloneable {
    UIComponent clone();
    void render(Pane pane, double x, double y, Integer parentId, ModularDesignStudio app);
    void accept(Visitor visitor);
    Style getStyle();
}