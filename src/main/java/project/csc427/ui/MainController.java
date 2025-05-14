package project.csc427.ui;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TreeView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.SelectionMode;
import javafx.event.ActionEvent;

public class MainController {

    @FXML
    private Canvas canvas;

    @FXML
    private TreeView<String> componentTree;

    @FXML
    private void initialize() {
        componentTree.setRoot(new TreeItem<>(""));
        componentTree.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        componentTree.setShowRoot(false);
    }

    @FXML
    void onNewLabel(ActionEvent evt) {
        var root = componentTree.getSelectionModel().getSelectedItem();
        root = root == null ? componentTree.getRoot() : root;

        root.getChildren().add(new TreeItem<>("Label: newLabel"));
    }

}
