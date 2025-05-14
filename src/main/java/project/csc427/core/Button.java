package project.csc427.core;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public final class Button extends BasicComponent {
    private String value;

    public Button(String name, Component parent) {
        super(name, parent);
        value = "Button";
        setSize(100, 30); // Default size
    }

    public Button(String name, Component parent, String text) {
        super(name, parent);
        value = text;
        setSize(100, 30); // Default size
    }

    @Override
    public boolean draw(GraphicsContext gc) {
        float[] position = getPosition();
        float[] size = getSize();

        // Draw button background and border
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(position[0], position[1], size[0], size[1]);
        gc.setStroke(Color.BLACK);
        gc.strokeRect(position[0], position[1], size[0], size[1]);

        // Draw text centered
        gc.setFill(Color.BLACK);
        gc.setFont(new Font("Arial", 14)); // Set font for readability
        double textWidth = gc.getFont().getSize() * value.length() * 0.6; // Approximate text width
        double textX = position[0] + (size[0] - textWidth) / 2; // Center horizontally
        double textY = position[1] + (size[1] + gc.getFont().getSize() / 2) / 2; // Center vertically
        gc.fillText(value, textX, textY);

        return true;
    }

    public void setText(String text) {
        value = text;
    }

    public String getText() {
        return value;
    }
}