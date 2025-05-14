package project.csc427.core;

public class XMLExportVisitor implements Visitor {
    private StringBuilder xmlOutput;
    private int indentLevel;

    public XMLExportVisitor() {
        xmlOutput = new StringBuilder();
        indentLevel = 0;
        xmlOutput.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
    }

    private String getIndent() {
        return "  ".repeat(indentLevel);
    }

    @Override
    public void visitLabel(Label label) {
        float[] position = label.getPosition();
        float[] size = label.getSize();
        xmlOutput.append(getIndent())
                .append(String.format("<Label name=\"%s\" x=\"%.2f\" y=\"%.2f\" width=\"%.2f\" height=\"%.2f\" text=\"%s\"/>\n",
                        label.getName(), position[0], position[1], size[0], size[1], label.getText()));
    }

    @Override
    public void visitTextbox(Textbox textbox) {
        float[] position = textbox.getPosition();
        float[] size = textbox.getSize();
        xmlOutput.append(getIndent())
                .append(String.format("<Textbox name=\"%s\" x=\"%.2f\" y=\"%.2f\" width=\"%.2f\" height=\"%.2f\" text=\"%s\"/>\n",
                        textbox.getName(), position[0], position[1], size[0], size[1], textbox.getText()));
    }

    @Override
    public void visitButton(Button button) {
        float[] position = button.getPosition();
        float[] size = button.getSize();
        xmlOutput.append(getIndent())
                .append(String.format("<Button name=\"%s\" x=\"%.2f\" y=\"%.2f\" width=\"%.2f\" height=\"%.2f\" text=\"%s\"/>\n",
                        button.getName(), position[0], position[1], size[0], size[1], button.getText()));
    }

    @Override
    public void visitHBoxLayout(HBoxLayout hbox) {
        float[] position = hbox.getPosition();
        float[] size = hbox.getSize();
        xmlOutput.append(getIndent())
                .append(String.format("<HBoxLayout name=\"%s\" x=\"%.2f\" y=\"%.2f\" width=\"%.2f\" height=\"%.2f\">\n",
                        hbox.getName(), position[0], position[1], size[0], size[1]));
        indentLevel++;
        for (Component child : hbox.iterator()) {
            child.accept(this);
        }
        indentLevel--;
        xmlOutput.append(getIndent()).append("</HBoxLayout>\n");
    }

    @Override
    public void visitVBoxLayout(VBoxLayout vbox) {
        float[] position = vbox.getPosition();
        float[] size = vbox.getSize();
        xmlOutput.append(getIndent())
                .append(String.format("<VBoxLayout name=\"%s\" x=\"%.2f\" y=\"%.2f\" width=\"%.2f\" height=\"%.2f\">\n",
                        vbox.getName(), position[0], position[1], size[0], size[1]));
        indentLevel++;
        for (Component child : vbox.iterator()) {
            child.accept(this);
        }
        indentLevel--;
        xmlOutput.append(getIndent()).append("</VBoxLayout>\n");
    }

    public String getXML() {
        return xmlOutput.toString();
    }
}