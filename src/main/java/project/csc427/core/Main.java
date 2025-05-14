package project.csc427.core;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(400, 300);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Create a VBoxLayout with children
        VBoxLayout vbox = new VBoxLayout("vbox", null);
        vbox.setPosition(20, 20);
        vbox.addChild("label1", new Label("label1", vbox, "Hello"));
        vbox.addChild("textbox1", new Textbox("textbox1", vbox, "Enter text"));
        vbox.addChild("label2", new Label("label2", vbox, "World"));
        vbox.draw(gc);

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, 400, 300);
        stage.setTitle("Component Test");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}