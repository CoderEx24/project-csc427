package modular.design.studio;

public interface Visitor {
    void visit(Panel panel);
    void visit(Button button);
    void visit(Textbox textbox);
    void visit(Dropdown dropdown);
}