package modular.design.studio;

import java.util.Iterator;
import java.util.List;

public class PanelIterator implements Iterator<UIComponent> {
    private final List<UIComponent> components;
    private int index;

    public PanelIterator(List<UIComponent> components) {
        this.components = components;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < components.size();
    }

    @Override
    public UIComponent next() {
        return components.get(index++);
    }
}