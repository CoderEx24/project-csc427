package modular.design.studio;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Panel implements UIComponent {
    private final Style style;
    private final List<UIComponent> components = new ArrayList<>();
    private Integer canvasId;

    public Panel(Style style) {
        this.style = style;
    }

    public void addComponent(UIComponent component) {
        components.add(component);
    }

    public void removeComponent(UIComponent component) {
        components.remove(component);
    }

    @Override
    public UIComponent clone() {
        Panel newPanel = new Panel(style);
        for (UIComponent component : components) {
            newPanel.addComponent(component.clone());
        }
        return newPanel;
    }

    @Override
    public void render(Pane pane, double x, double y, Integer parentId, ModularDesignStudio app) {
        Rectangle rect = new Rectangle(x, y, 250, 200);
        rect.setFill(javafx.scene.paint.Color.web(style.getColor()));
        rect.setStroke(javafx.scene.paint.Color.BLACK);
        pane.getChildren().add(rect);
        this.canvasId = rect.hashCode();
        app.registerDraggable(rect, parentId);

        double yOffset = y + 20;
        for (UIComponent component : components) {
            component.render(pane, x + 20, yOffset, canvasId, app);
            yOffset += 40;
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (UIComponent component : components) {
            component.accept(visitor);
        }
    }

    @Override
    public Style getStyle() {
        return style;
    }

    public Iterator<UIComponent> iterator() {
        return new PanelIterator(components);
    }
}