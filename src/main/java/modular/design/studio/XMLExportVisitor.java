package modular.design.studio;

public class XMLExportVisitor implements Visitor {
    private final StringBuilder xml = new StringBuilder();

    public String getXML() {
        return xml.toString();
    }

    @Override
    public void visit(Panel panel) {
        xml.append("<Panel style=\"").append(panel.getStyle()).append("\">\n");
    }

    @Override
    public void visit(Button button) {
        xml.append("  <Button style=\"").append(button.getStyle()).append("\"/>\n");
    }

    @Override
    public void visit(Textbox textbox) {
        xml.append("  <Textbox style=\"").append(textbox.getStyle())
           .append("\" text=\"").append(textbox.getText()).append("\"/>\n");
    }

    @Override
    public void visit(Dropdown dropdown) {
        xml.append("  <Dropdown style=\"").append(dropdown.getStyle())
           .append("\" selected=\"").append(dropdown.getSelectedOption()).append("\"/>\n");
    }
}