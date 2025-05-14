package project.csc427.core;

import javafx.scene.canvas.GraphicsContext;
import java.util.List;
import java.util.ArrayList;

public final class Listbox extends BasicComponent {
  private List<String> items;
  private int selectedIndex;

  public Listbox(String n, Component p) {
    super(n, p);
    this.items = new ArrayList<>();
    this.selectedIndex = -1; // No selection by default
  }

  public void addItem(String item) {
    items.add(item);
  }

  public void removeItem(String item) {
    items.remove(item);
  }

  public void setSelectedIndex(int index) {
    if (index >= 0 && index < items.size()) {
      selectedIndex = index;
    }
  }

  public int getSelectedIndex() {
    return selectedIndex;
  }

  public List<String> getItems() {
    return items;
  }

  @Override
  public boolean draw(GraphicsContext gc) {
    float[] pos = getPosition();
    float[] size = getSize();

    double x = pos[0];
    double y = pos[1];
    double width = size[0];
    double height = size[1];

    // Draw bounding box
    gc.strokeRect(x, y, width, height);

    // Draw items
    double itemHeight = 20;
    for (int i = 0; i < items.size(); i++) {
      if (i == selectedIndex) {
        gc.fillRect(x, y + i * itemHeight, width, itemHeight);
        gc.setFill(javafx.scene.paint.Color.WHITE);
      } else {
        gc.setFill(javafx.scene.paint.Color.BLACK);
      }
      gc.fillText(items.get(i), x + 5, y + (i + 1) * itemHeight - 5);
    }

    return true;
  }

  @Override
  public void accept(Exporter v) {
    v.visit(this);
  }
}

