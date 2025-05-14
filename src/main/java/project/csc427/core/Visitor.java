package project.csc427.core;

public interface Visitor {
    void visitLabel(Label label);
    void visitTextbox(Textbox textbox);
    void visitButton(Button button);
    void visitHBoxLayout(HBoxLayout hbox);
    void visitVBoxLayout(VBoxLayout vbox);
}