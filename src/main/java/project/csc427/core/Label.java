package project.csc427.core;

import project.csc427.core.BasicComponent;
import javafx.scene.canvas.GraphicsContext;;

public final class Label extends BasicComponent {
  private String value;

  public Label(Component p) {
    super(p);
    value = "Label";
  }

  public Label(Component p, String t) {
    super(p);
    value = t;
  }

  public boolean draw(GraphicsContext gc) {
    float[] position = getPosition();

    gc.fillText(value, position[0], position[1]);
    return true;
  }

}

