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
        componentTreeRoot.setSize(300, 300);
        componentTree.setRoot(new TreeItem<>(componentTreeRoot));
        componentTree.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        labelCounter = 0;
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
    }

}
