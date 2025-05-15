package project.csc427.ui;

import project.csc427.core.component.*;
import project.csc427.core.component.layout.*;
import project.csc427.core.export.*;
import static project.csc427.Main.getExportFile;

import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TreeView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeCell;
import javafx.scene.control.SelectionMode;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.application.Application;

public class MainController {
    
    private Component componentTreeRoot;
    private long labelCounter;
    private long listboxCounter;
    private long dropdownCounter;
    private long textboxCounter;
    private long vboxCounter;
    private long gridCounter;
    private long buttonCounter;

    @FXML
    private Canvas canvas;

    @FXML
    private TreeView<Component> componentTree;

    @FXML
    private void initialize() {
        componentTree.setCellFactory(tv -> {
            return new TreeCell<Component>() {
                @Override
                public void updateItem(Component comp, boolean empty) {
                    super.updateItem(comp, empty);

                    if (empty) {
                        setText(null);
                    } else {
                        setText(comp.getName());
                    }
                }
            };
        });

        componentTreeRoot = new HBoxLayout("Root", null);
        componentTreeRoot.setPosition(0, 200);
        componentTreeRoot.setSize(300, 300);
        componentTree.setRoot(new TreeItem<>(componentTreeRoot));
        componentTree.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        vboxCounter = textboxCounter = dropdownCounter = 
            gridCounter = listboxCounter =
            buttonCounter = labelCounter = 0;
    }

    @FXML
    void onNewElement(ActionEvent evt) {
        var root = componentTree.getSelectionModel().getSelectedItem();
        root = root == null ? componentTree.getRoot() : root;

        Component comp;
        String name;
        
        switch (((Node) evt.getSource()).getId()) {

            case "Label":
                name = "label" + labelCounter++;
                comp = new Label(name, root.getValue());
                comp.setSize(20, 20);
                ((Label) comp).setText("Label");
                break;

            case "Textbox":
                name = "textbox" + textboxCounter++;
                comp = new Textbox(name, root.getValue());
                comp.setSize(120, 30);
                ((Textbox) comp).setText("placeholder");
                break;

            case "Dropdown":
                name = "dropdown" + dropdownCounter++;
                comp = new Dropdown(name, root.getValue());
                comp.setSize(120, 30);
                ((Dropdown) comp).addOption("Default");
                
                break;

            case "VBoxLayout":
                name = "VBoxLayout" + vboxCounter++;
                comp = new VBoxLayout(name, root.getValue());
                comp.setSize(100, 300);
        
                break;

            case "HBoxLayout":
                name = "VBoxLayout" + vboxCounter++;
                comp = new HBoxLayout(name, root.getValue());
                comp.setSize(300, 100);
                break;

            case "GridLayout":
                name = "grid" + gridCounter++;
                comp = new GridLayout(name, root.getValue());
                ((GridLayout) comp).setRows(3);
                ((GridLayout) comp).setColumns(3);
                break;

            case "Listbox":
                name = "listbox" + listboxCounter++;
                comp = new Listbox(name, root.getValue());
                ((Listbox) comp).setSize(120, 100);
                ((Listbox) comp).addItem("Item 1");
                ((Listbox) comp).addItem("Item 2");
                ((Listbox) comp).addItem("Item 3");
                break;

            case "Button":
                name = "button" + buttonCounter++;
                comp = new Button(name, root.getValue());
                comp.setSize(100, 40);
                ((Button) comp).setText("Button");
            default: return;

        }
        
        root.getValue().addChild(name, comp);
        root.getChildren().add(new TreeItem<Component>(comp));

        var gc = canvas.getGraphicsContext2D();

        gc.clearRect(0, 0, 1200, 1200);
        componentTreeRoot.draw(gc);
    }

    @FXML
    void onExport(ActionEvent evt) {
        File f = getExportFile();
        if (f == null)
            return;

        Exporter exporter = new XMLExporter();
        componentTreeRoot.accept(exporter);

        exporter.exportToFile(f.getPath());
    }

}
