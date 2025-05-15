package project.csc427;

import project.csc427.core.export.*;

import java.io.File;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.FileChooser;

public class Main extends Application {

  private static Stage primaryStage;

  public void start(Stage stage) {
    primaryStage = stage;
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

  public static File getExportFile() {
    FileChooser diag = new FileChooser();
    diag.setTitle("FigmaKiller - Export to XML");
    return diag.showSaveDialog(primaryStage);
  }

  public static void main(String[] args) {
    System.out.println("Hello World");
    launch(args);
  }
}

