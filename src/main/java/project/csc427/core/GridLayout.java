package project.csc427.core;

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
      throw new IllegalArgumentException("Row count must be larger than 1");
    }

    rows = v;
  }

  public void setColumns(int v) {
    if (v < 1) {
      throw new IllegalArgumentException("Column count must be larger than 1");
    }

    columns = v;
  }
  public boolean addChild(String name, Component comp) {
    if (children.size() == rows * columns)
      return false;

    children.put(name, comp);
    return true;
  }

  public boolean removeChild(String name) {
    children.remove(name);
    return true;
  }

  public Component getChild(String name) {
    return children.get(name);
  }
  
  public Iterator<Component> iterator() {
    return children.sequencedValues().iterator();
  }

  public boolean layout() {
    int i = 0, j = 0;
    float[] origin = getPosition();

    // TODO: take child size into account
    for (var child : children.values()) {
      float[] position = new float[] { 0, 0 };

      position[0] = origin[0] + i * (getSize()[0] / rows);
      position[1] = origin[1] + j * (getSize()[1] / columns);

      i ++;
      if (i == rows) {
        i = 0;
        j ++;
      }

      child.setPosition(position[0], position[1]);
    }

    return true;
  }

  @Override
  public void accept(Exporter v) {
    v.visit(this);
  }
}

