package project.csc427.core.component.layout;

import project.csc427.core.component.*;
import project.csc427.core.export.Exporter;
import java.util.Iterator;
import java.util.SequencedMap;
import java.util.LinkedHashMap;

public final class GridLayout extends BasicComponent implements Layout {
  private SequencedMap<String, Component> children;
  private int rows, columns;

  public GridLayout(String n, Component p) {
    super(n, p);
    children = new LinkedHashMap<>();
  }

  public int getRows() {
    return rows;
  }

  public int getColumns() {
    return columns;
  }

  public void setRows(int v) {
    if (v < 1) {
      throw new IllegalArgumentException("Row count must be at least 1");
    }
    rows = v;
  }

  public void setColumns(int v) {
    if (v < 1) {
      throw new IllegalArgumentException("Column count must be at least 1");
    }
    columns = v;
  }

  @Override
  public boolean addChild(String name, Component comp) {
    if (children.size() >= rows * columns) {
      return false;
    }
    children.put(name, comp);
    return true;
  }

  @Override
  public boolean removeChild(String name) {
    children.remove(name);
    return true;
  }

  @Override
  public Component getChild(String name) {
    return children.get(name);
  }

  @Override
  public Iterator<Component> iterator() {
    return children.sequencedValues().iterator();
  }

  @Override
  public boolean layout() {
    float[] origin = getPosition();
    float cellWidth = getSize()[0] / columns;
    float cellHeight = getSize()[1] / rows;
    int row = 0, col = 0;

    for (var child : children.values()) {
      float[] childSize = child.getSize();
      // Center child in cell
      float x = origin[0] + col * cellWidth + (cellWidth - childSize[0]) / 2;
      float y = origin[1] + row * cellHeight + (cellHeight - childSize[1]) / 2;
      child.setPosition(x, y);
      col++;
      if (col >= columns) {
        col = 0;
        row++;
      }
    }
    return true;
  }

  @Override
  public void accept(Exporter visitor) {
    visitor.visit(this);
  }
}