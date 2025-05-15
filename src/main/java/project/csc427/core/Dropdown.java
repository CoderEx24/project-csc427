package project.csc427.core;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import java.util.Deque;
import java.util.LinkedList;

public class Dropdown extends BasicComponent {
  private Deque<String> options;

  public Dropdown(String name, Component parent) {
    super(name, parent);
    options = new LinkedList<>();
  }

  public void addOption(String v) {
    options.add(v);
  }

  public void removeOption(String v) {
    options.remove(v);
  }

  public Deque<String> getOptions() {
    return options;
  }

  @Override
  public boolean draw(GraphicsContext gc) {
    float[] position = getPosition();
    float[] size = getSize();
    gc.setStroke(Color.BLACK);
    gc.strokeRect(position[0], position[1], size[0], size[1]);
    String v = options.peek();
    if (v != null) {
      gc.strokeText(v, position[0], position[1]);
    }
    gc.beginPath();
    gc.fillArc(position[0] + size[0] - 20, position[1] + size[1] / 2 - 10, 20, 20, 0, 360, ArcType.ROUND);
    gc.closePath();
    return true;
  }

  @Override
  public void accept(Exporter visitor) {
    visitor.visit(this);
  }
}