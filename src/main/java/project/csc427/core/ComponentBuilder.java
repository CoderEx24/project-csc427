package project.csc427.core;

import java.util.Collections;

public final class ComponentBuilder {

  private Component root;

  public ComponentBuilder() {}

  public ComponentBuilder setRoot(Layout r) {
    root = r;

    return this;
  }

  public ComponentBuilder back() {
    var parent = root.getParent();
    root = parent == null ? root : parent;

    return this;
  }

  public ComponentBuilder goTo(String name) {
    var target = root.getChild(name);

    if (target != null && target instanceof Layout)
      root = target;

    return this;
  }

  public ComponentBuilder addButton(String name, String text, float w, float h) {
    Button btn = new Button(name, root);
    btn.setSize(w, h);
    btn.setText(text);

    root.addChild(name, btn);

    return this;
  }

  public ComponentBuilder addDropdown(String name, float w, float h, String... options) {
    Dropdown comp = new Dropdown(name, root);
    comp.setSize(w, h);

    for (var o : options)
      comp.addOption(o);

    root.addChild(name, comp);
    return this;
  }

  public ComponentBuilder addLabel(String name, String text, float w, float h) {
    Label comp = new Label(name, root, text);
    comp.setSize(w, h);

    root.addChild(name, comp);
    return this;
  }

  public ComponentBuilder addListbox(String name, float w, float h, String... options) {
    Listbox comp = new Listbox(name, root);
    comp.setSize(w, h);

    for (var o : options)
      comp.getItems().add(o);

    root.addChild(name, comp);
    return this;
  }

  public Component build() {
    return root;
  }
}

