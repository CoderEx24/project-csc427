package project.csc427.core;

import java.util.SequencedMap;
import java.util.LinkedHashMap;

public final class HBoxLayout extends BasicComponent implements Layout {
  private SequencedMap<String, Component> children;

  public HBoxLayout(Component p) {
    super(p);
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

  public boolean layout() {
    float[] origin = getPosition();
    float runningYCoord = 0;

    for (var child : children.values()) {
      float[] size = child.getSize();
      float[] position = child.getPosition();

      position[0] = origin[0];
      position[1] = origin[1] + runningYCoord;

      child.setPosition(position[0], position[1]);

      // TODO: paramterise padding
      runningYCoord += size[1] + 20;
    }
  
    return true;
  }

}

