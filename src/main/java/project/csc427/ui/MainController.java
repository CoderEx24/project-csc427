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
    private long vboxCounter;

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
            listboxCounter = labelCounter = 0;
    }

    @FXML
    void onNewLabel(ActionEvent evt) {
        var root = componentTree.getSelectionModel().getSelectedItem();
        root = root == null ? componentTree.getRoot() : root;
        
        String name = "label" + labelCounter++;
        Label comp = new Label(name, root.getValue());
        comp.setSize(20, 20);
        comp.setText("Label");

        root.getValue().addChild(name, comp);
        root.getChildren().add(new TreeItem<>(comp));

        var gc = canvas.getGraphicsContext2D();

        gc.clearRect(0, 0, 500, 500);
        componentTreeRoot.draw(gc);

        System.out.println(evt.getTarget());
    }

    @FXML
    void onNewListbox(ActionEvent evt) {
        var root = componentTree.getSelectionModel().getSelectedItem();
        root = root == null ? componentTree.getRoot() : root;

        String name = "listbox" + listboxCounter++;
        Listbox comp = new Listbox(name, root.getValue());
        comp.setSize(120, 100);
        comp.addItem("Item 1");
        comp.addItem("Item 2");
        comp.addItem("Item 3");
        
        root.getValue().addChild(name, comp);
        root.getChildren().add(new TreeItem<>(comp));

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
        
        root.getValue().addChild(name, comp);
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
        
        root.getValue().addChild(name, comp);
        root.getChildren().add(new TreeItem<Component>(comp));

        var gc = canvas.getGraphicsContext2D();

        gc.clearRect(0, 0, 500, 500);
        componentTreeRoot.draw(gc);
    }

    @FXML
    void onNewVBoxLayout(ActionEvent evt) {
        var root = componentTree.getSelectionModel().getSelectedItem();
        root = root == null ? componentTree.getRoot() : root;

        String name = "VBoxLayout" + vboxCounter++;
        VBoxLayout comp = new VBoxLayout(name, root.getValue());
        comp.setSize(100, 300);
        
        root.getValue().addChild(name, comp);
        root.getChildren().add(new TreeItem<Component>(comp));

        var gc = canvas.getGraphicsContext2D();

        gc.clearRect(0, 0, 500, 500);
        componentTreeRoot.draw(gc);
    }
}
