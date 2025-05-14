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
    private int labelCounter = 0;

    @FXML
    private Canvas canvas;

    @FXML
    private TreeView<Component> componentTree;

    @FXML
    private void initialize() {
        componentTree.setCellFactory((TreeView<Component> tv) -> {
            return new TreeCell<Component>() {
                @Override
                public void updateItem(Component item, boolean empty) {
                    if (empty) {
                        setText(null);
                        setGraphic(null);
                    } else {
                        //setText(item.getName());
                    }
                }
            };
        });

        Layout root = new HBoxLayout("Root", null);
        componentTree.setRoot(new TreeItem<>(root));
        componentTree.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    @FXML
    void onNewLabel(ActionEvent evt) {
        var root = componentTree.getSelectionModel().getSelectedItem();
        root = root == null ? componentTree.getRoot() : root;

        root.getChildren().add(
                new TreeItem<Component>(new Label("label" + labelCounter, root.getValue()))
        );

        labelCounter ++;
    }

}
