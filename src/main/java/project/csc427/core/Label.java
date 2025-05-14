package project.csc427.core;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public final class Label extends BasicComponent {
  private String value;

  public Label(String n, Component p) {
    super(n, p);
    value = "Label";
  }

  public Label(String n, Component p, String t) {
    super(n, p);
    value = t;
  }

  public boolean draw(GraphicsContext gc) {
    float[] position = getPosition();
    float[] size = getSize();

    gc.setStroke(Color.BLACK);
    gc.fillText(value, position[0], position[1]);

    return true;
  }

  public void setText(String v) {
    value = v;
  }
}

