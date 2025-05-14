package project.csc427.core;

public interface Exporter {
    void visit(Label label);
    void visit(Textbox textbox);
    void visit(Button button);
    void visit(HBoxLayout hbox);
    void visit(VBoxLayout vbox);

    boolean exportToFile(String filepath);
}
