package project.csc427.ui;

import project.csc427.core.*;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TreeView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeCell;
import javafx.scene.control.SelectionMode;
import javafx.event.ActionEvent;

public class MainController {
    
    private Component componentTreeRoot;
    private long labelCounter;
    private long listboxCounter;
    private long dropdownCounter;
    private long textboxCounter;

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
        dropdownCounter = listboxCounter = labelCounter = 0;
    }

    @FXML
    void onNewLabel(ActionEvent evt) {
        var root = componentTree.getSelectionModel().getSelectedItem();
        root = root == null ? componentTree.getRoot() : root;

        String str = "label" + labelCounter++;
        Component newLabel = new Label(str, root.getValue());
        newLabel.setSize(20, 20);
        componentTreeRoot.addChild(str, newLabel);
        ((Label) newLabel).setText("Label");
        root.getChildren().add(new TreeItem<>(newLabel));

        var gc = canvas.getGraphicsContext2D();

        gc.clearRect(0, 0, 500, 500);
        componentTreeRoot.draw(gc);

        System.out.println(evt.getTarget());
    }

    @FXML
    void onNewListbox(ActionEvent evt) {
        var root = componentTree.getSelectionModel().getSelectedItem();
        root = root == null ? componentTree.getRoot() : root;

        String boxName = "listbox" + listboxCounter++;
        Listbox listBox = new Listbox(boxName, root.getValue());
        listBox.setSize(120, 100);
        listBox.addItem("Item 1");
        listBox.addItem("Item 2");
        listBox.addItem("Item 3");

        componentTreeRoot.addChild(boxName, listBox);
        root.getChildren().add(new TreeItem<Component>(listBox));

        var gc = canvas.getGraphicsContext2D();
        
        gc.clearRect(0, 0, 500, 500);
        componentTreeRoot.draw(gc);
    }

    @FXML
    void onNewDropdown(ActionEvent evt) {
        var root = componentTree.getSelectionModel().getSelectedItem();
        root = root == null ? componentTree.getRoot() : root;

        String name = "dropdown" + dropdownCounter++;
        Dropdown comp = new Dropdown(name, root.getValue());
        comp.setSize(120, 30);
        comp.addOption("Default");
        
        componentTreeRoot.addChild(name, comp);
        root.getChildren().add(new TreeItem<Component>(comp));

        var gc = canvas.getGraphicsContext2D();

        gc.clearRect(0, 0, 500, 500);
        componentTreeRoot.draw(gc);
    }

    @FXML
    void onNewTextbox(ActionEvent evt) {
        var root = componentTree.getSelectionModel().getSelectedItem();
        root = root == null ? componentTree.getRoot() : root;

        String name = "textbox" + textboxCounter++;
        Textbox comp = new Textbox(name, root.getValue());
        comp.setSize(120, 30);
        comp.setText("placeholder");
        
        componentTreeRoot.addChild(name, comp);
        root.getChildren().add(new TreeItem<Component>(comp));

        var gc = canvas.getGraphicsContext2D();

        gc.clearRect(0, 0, 500, 500);
        componentTreeRoot.draw(gc);

    }
}
