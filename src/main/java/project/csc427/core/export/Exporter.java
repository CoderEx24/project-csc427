package project.csc427.core.export;

import project.csc427.core.component.*;
import java.io.FileWriter;

public interface Exporter {
    void visit(Label label);
    void visit(Textbox textbox);
    void visit(Button button);
    void visit(HBoxLayout hbox);
    void visit(VBoxLayout vbox);
    void visit(Listbox lbox);
    void visit(Dropdown dd);
    void visit(GridLayout grid);

    default boolean exportToFile(String filepath) {

        try(var writer = new FileWriter(filepath)) {
            writer.write(exportToString());

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    String exportToString();
}
