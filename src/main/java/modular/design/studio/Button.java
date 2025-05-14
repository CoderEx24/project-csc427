package modular.design.studio;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Button implements UIComponent {
    private final Style style;
    private Integer canvasId;

    public Button(Style style) {
        this.style = style;
    }

    @Override
    public UIComponent clone() {
        return new Button(style);
    }

    @Override
    public void render(Pane pane, double x, double y, Integer parentId, ModularDesignStudio app) {
        Rectangle rect = new Rectangle(x, y, 100, 30);
        rect.setFill(javafx.scene.paint.Color.web(style.getColor()));
        rect.setStroke(javafx.scene.paint.Color.BLACK);
        Text text = new Text(x + 50, y + 15, "Button");
        text.setFont(new javafx.scene.text.Font(style.getFont(), style.getSize()));
        pane.getChildren().addAll(rect, text);
        this.canvasId = rect.hashCode();
        app.registerButton(rect, this);
        app.registerDraggable(rect, parentId);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Style getStyle() {
        return style;
    }
}