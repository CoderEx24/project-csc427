package project.csc427.core.component;

public abstract class BasicComponent implements Component {
  private float width, height, x, y;
  private Component parent;
  private String name;

  public BasicComponent(String n, Component p) {
    if (p == null) {
      width = height = x = y = 0f;

    } else {
      float[] parentPosition = p.getPosition();
      float[] parentSize = p.getSize();

      width = parentPosition[0];
      height = parentPosition[1];
      x = parentSize[0];
      y = parentSize[1];

    }

    name = n;
    parent = p;
  }

  public void setSize(float w, float h) {
    width = w;
    height = h;
  }

  public void setPosition(float x, float y) {
    this.x = x;
    this.y = y;
  }

  public float[] getSize() {
    return new float[] { width, height };
  }

  public float[] getPosition() {
    return new float[] { x, y };
  }

  public Component getParent() {
    return parent;
  }

  public String getName() {
    return name;
  }
}

