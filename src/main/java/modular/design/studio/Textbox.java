package modular.design.studio;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Textbox implements UIComponent {
    private final Style style;
    private Integer canvasId;
    private String text = "";

    public Textbox(Style style) {
        this.style = style;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public UIComponent clone() {
        Textbox newTextbox = new Textbox(style);
        newTextbox.setText(text);
        return newTextbox;
    }

    @Override
    public void render(Pane pane, double x, double y, Integer parentId, ModularDesignStudio app) {
        Rectangle rect = new Rectangle(x, y, 100, 30);
        rect.setFill(javafx.scene.paint.Color.web(style.getColor()));
        rect.setStroke(javafx.scene.paint.Color.BLACK);
        Text textNode = new Text(x + 50, y + 15, text.isEmpty() ? "Textbox" : text);
        textNode.setFont(new javafx.scene.text.Font(style.getFont(), style.getSize()));
        pane.getChildren().addAll(rect, textNode);
        this.canvasId = rect.hashCode();
        app.registerTextbox(rect, this, textNode);
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