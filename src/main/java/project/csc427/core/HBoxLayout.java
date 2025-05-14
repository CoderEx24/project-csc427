package project.csc427.core;

import java.util.Iterator;
import java.util.SequencedMap;
import java.util.LinkedHashMap;

public final class HBoxLayout extends BasicComponent implements Layout {
  private SequencedMap<String, Component> children;

  public HBoxLayout(String n, Component p) {
    super(n, p);
    children = new LinkedHashMap<>();
  }

  public boolean addChild(String name, Component comp) {
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
    float[] origin = getPosition();
    float runningXCoord = 0;

    for (var child : children.values()) {
      float[] size = child.getSize();
      float[] position = child.getPosition();

      position[0] = origin[0] + runningXCoord;
      position[1] = origin[1];

      child.setPosition(position[0], position[1]);

      // TODO: paramterise padding
      runningXCoord += size[0] + 20;
    }
  
    return true;
  }
  @Override
  public void accept(Exporter visitor) {
    visitor.visit(this);
  }
}

