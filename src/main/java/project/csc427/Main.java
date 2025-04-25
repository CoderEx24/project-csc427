package project.csc427;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;

public class Main extends Application {
  public void start(Stage stage) {
    VBox root = new VBox();
    Label l = new Label("Fuck Figma & Fuck Javascript");
    Button b = new Button("Exit");

    b.setOnAction(_t -> Platform.exit());

    root.getChildren().addAll(l, b);
    Scene s = new Scene(new StackPane(root), 140, 140);
    stage.setScene(s);
    stage.setTitle("FigmaKiller");
    stage.show();
  }

  public static void main(String[] args) {
    System.out.println("Hello World");
    launch(args);
  }
}

