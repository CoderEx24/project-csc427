package project.csc427.core.component.layout;

import project.csc427.core.component.*;
import project.csc427.core.export.Exporter;

import java.util.Iterator;
import java.util.SequencedMap;
import java.util.LinkedHashMap;

public final class VBoxLayout extends BasicComponent implements Layout {
    private SequencedMap<String, Component> children;

    public VBoxLayout(String name, Component parent) {
        super(name, parent);
        children = new LinkedHashMap<>();
    }

    @Override
    public boolean addChild(String name, Component comp) {
        children.put(name, comp);
        return true;
    }

    @Override
    public boolean removeChild(String name) {
        children.remove(name);
        return true;
    }

    @Override
    public Component getChild(String name) {
        return children.get(name);
    }

    @Override
    public Iterator<Component> iterator() {
        return children.sequencedValues().iterator();
    }

    @Override
    public boolean layout() {
        float[] origin = getPosition();
        float runningYCoord = 0;

        for (var child : children.values()) {
            float[] size = child.getSize();
            float[] position = child.getPosition();

            position[0] = origin[0];
            position[1] = origin[1] + runningYCoord;

            child.setPosition(position[0], position[1]);

            // TODO: parameterize padding
            runningYCoord += size[1] + 20;
        }

        return true;
    }
    @Override
    public void accept(Exporter visitor) {
        visitor.visit(this);
    }
}
