package project.csc427.builder;

import project.csc427.core.*;
import project.csc427.core.Layout;  // for layouts
import project.csc427.core.Dropbox;
import project.csc427.core.GridLayout;
import project.csc427.core.ListBox;
import project.csc427.core.VBoxLayout;
import project.csc427.core.Dropdown;

public class ComponentBuilder {
    private String name;
    private Component parent;
    private float width = 100, height = 30, x = 0, y = 0;
    private String text;           // for Label, Button
    private String imagePath;      // for PhotoComponent
    private ComponentType type;

    public enum ComponentType {
        LABEL,
        BUTTON,
        PHOTO,
        LISTBOX,
        VBOXLAYOUT,
        DROPBOX,
        GRIDLAYOUT,
        DROPDOWN
    }

    public ComponentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ComponentBuilder setParent(Component parent) {
        this.parent = parent;
        return this;
    }

    public ComponentBuilder setSize(float width, float height) {
        this.width = width;
        this.height = height;
        return this;
    }

    public ComponentBuilder setPosition(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public ComponentBuilder setText(String text) {
        this.text = text;
        return this;
    }

    public ComponentBuilder setImagePath(String imagePath) {
        this.imagePath = imagePath;
        return this;
    }

    public ComponentBuilder setType(ComponentType type) {
        this.type = type;
        return this;
    }

    public Component build() {
        if (type == null) {
            throw new IllegalStateException("ComponentType must be set");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalStateException("Name must be set");
        }

        Component comp;
        switch (type) {
            case LABEL:
                comp = new Label(name, parent, text != null ? text : "Label");
                break;
            case BUTTON:
                comp = new Button(name, parent, text != null ? text : "Button");
                break;
            case PHOTO:
                comp = new PhotoComponent(name, parent, imagePath != null ? imagePath : "");
                break;
            case LISTBOX:
                comp = new ListBox(name, parent);
                break;
            case VBOXLAYOUT:
                comp = new VBoxLayout(name, parent);
                break;
            case DROPBOX:
                comp = new Dropbox(name, parent);
                break;
            case GRIDLAYOUT:
                comp = new GridLayout(name, parent);
                break;
            case DROPDOWN:
                comp = new Dropdown(name, parent);
                break;
            default:
                throw new IllegalArgumentException("Unknown component type: " + type);
        }

        comp.setSize(width, height);
        comp.setPosition(x, y);
        return comp;
    }
}