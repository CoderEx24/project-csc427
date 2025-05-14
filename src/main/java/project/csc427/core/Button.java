package project.csc427.core;

import javafx.scene.canvas.GraphicsContext;

public final class Button extends BasicComponent {

  public Button(String name, Component parent) {
    super(name, parent);

  }

  @Override
  public boolean draw(GraphicsContext gc) {
    
    return false;
  }

}

