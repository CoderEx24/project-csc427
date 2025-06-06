package project.csc427.core.component;

import project.csc427.core.export.Exporter;
import java.util.Iterator;
import javafx.scene.canvas.GraphicsContext;

public interface Component {

  public boolean draw(GraphicsContext gc);

  public default boolean addChild(String name, Component comp) {
    throw new UnsupportedOperationException();
  }

  public default boolean removeChild(String name) {
    throw new UnsupportedOperationException();
  }

  public default Component getChild(String name) {
    throw new UnsupportedOperationException();
  }

  public default Iterator<Component> iterator() {
    throw new UnsupportedOperationException();
  }

  public void accept(Exporter visitor);

  public Component getParent();
  public void setSize(float w, float h);
  public void setPosition(float x, float y);
  public float[] getSize();
  public float[] getPosition();
  public String getName();
}

