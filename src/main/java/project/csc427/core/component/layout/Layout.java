package project.csc427.core.component.layout;

import project.csc427.core.component.Component;
import javafx.scene.canvas.GraphicsContext;

public interface Layout extends Component {
  public boolean layout();

  public default boolean draw(GraphicsContext gc) {
    layout();

    for (var it = iterator(); it.hasNext(); ) {
      var elem = it.next();
      if (!elem.draw(gc))
        return false;

    }

    return true;
  }
}

