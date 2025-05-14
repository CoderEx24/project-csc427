package project.csc427.core;

import java.util.Iterator;

public final class GridLayout extends BasicComponent implements Layout {

  public GridLayout(String n, Component p) {
    super(n, p);
  }

  public boolean addChild(String name, Component comp) {
    return false;
  }

  public boolean removeChild(String name) {
    return false;
  }

  public Component getChild(String name) {
    return null;
  }
  
  public Iterator<Component> iterator() {
    return null;
  }

  public boolean layout() {

    return false;
  }

}

