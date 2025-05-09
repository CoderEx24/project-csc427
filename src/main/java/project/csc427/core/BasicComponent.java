package project.csc427.core;

public abstract class BasicComponent implements Component {
  private float width, height, x, y;
  private Component parent;

  public BasicComponent(Component p) {
    width = height = x = y = 0f;
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

}

