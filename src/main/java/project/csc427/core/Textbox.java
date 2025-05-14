package project.csc427.core;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public final class Textbox extends BasicComponent {
    private String value;

    public Textbox(String name, Component parent) {
        super(name, parent);
        value = "Textbox";
        setSize(100, 20); // Default size
    }

    public Textbox(String name, Component parent, String text) {
        super(name, parent);
        value = text;
        setSize(100, 20); // Default size
    }

    @Override
    public boolean draw(GraphicsContext gc) {
        float[] position = getPosition();
        float[] size = getSize();

        // Draw rectangle border
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.WHITE);
        gc.fillRect(position[0], position[1], size[0], size[1]);
        gc.strokeRect(position[0], position[1], size[0], size[1]);

        // Draw text inside
        gc.setFill(Color.BLACK);
        gc.fillText(value, position[0] + 5, position[1] + size[1] - 5);

        return true;
    }

    public void setText(String text) {
        value = text;
    }

    public String getText() {
        return value;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitTextbox(this);
    }
}