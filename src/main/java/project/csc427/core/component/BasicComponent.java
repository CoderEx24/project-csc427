package project.csc427.core.component;

public abstract class BasicComponent implements Component {
  private float width, height, x, y;
  private Component parent;
  private String name;

  public BasicComponent(String n, Component p) {
    name = n;
    parent = p;
    // Initialize defaults: zero if no parent, or inherit parent's position
    if (p == null) {
      width = height = x = y = 0f;
    } else {
      float[] parentPosition = p.getPosition();
      x = parentPosition[0];
      y = parentPosition[1];
      width = height = 0f; // Size set by component or factory
    }
  }

  @Override
  public void setSize(float w, float h) {
    width = w;
    height = h;
  }

  @Override
  public void setPosition(float x, float y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public float[] getSize() {
    return new float[] { width, height };
  }

  @Override
  public float[] getPosition() {
    return new float[] { x, y };
  }

  @Override
  public Component getParent() {
    return parent;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void accept(Exporter visitor) {
    // Default implementation, overridden by subclasses
  }
}