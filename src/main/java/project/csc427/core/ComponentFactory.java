package project.csc427.core;

public interface ComponentFactory {
    Label createLabel(String name, Component parent, String text);
    Textbox createTextbox(String name, Component parent, String text);
    Button createButton(String name, Component parent, String text);
    Dropdown createDropdown(String name, Component parent);
    Listbox createListbox(String name, Component parent);
    HBoxLayout createHBoxLayout(String name, Component parent);
    VBoxLayout createVBoxLayout(String name, Component parent);
    GridLayout createGridLayout(String name, Component parent, int rows, int columns);
}