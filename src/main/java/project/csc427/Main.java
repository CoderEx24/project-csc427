package project.csc427;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Main extends Application {
  public void start(Stage stage) {
    try {
      Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
      stage.setScene(new Scene(root));
      stage.setTitle("FigmaKiller");
      stage.show();
    } catch (Exception e) {
      System.err.println("[CRITICAL]: Failed to read Main.fxml, exiting");
      e.printStackTrace();
      Platform.exit();
    }
  }

  public static void main(String[] args) {
    System.out.println("Hello World");
    launch(args);
  }
}

