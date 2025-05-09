package project.csc427.core;

import javafx.scene.layout.Pane;

public interface Component {

  public boolean draw(Pane canvas);

  public default boolean addChild(String name, Component comp) {
    throw new UnsupportedOperationException();
  }

  public default boolean removeChild(String name, Component comp) {
    throw new UnsupportedOperationException();
  }

  public default Component getChild(String name, Component comp) throws UnsupportedOperationException {
    throw new UnsupportedOperationException();
  }

  public Component getParent();
  public void setSize(float w, float h);
  public void setPosition(float x, float y);
  public float[] getSize();
  public float[] getPosition();
  
}

