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

        // Use Windows theme
        ComponentFactory windowsFactory = new WindowsThemeFactory();
        VBoxLayout windowsVbox = windowsFactory.createVBoxLayout("windows_vbox", null);
        windowsVbox.setPosition(20, 20);
        windowsVbox.setSize(360, 260);

        Label label1 = windowsFactory.createLabel("label1", windowsVbox, "Hello");
        Textbox textbox1 = windowsFactory.createTextbox("textbox1", windowsVbox, "Enter text");
        Dropdown dropdown1 = windowsFactory.createDropdown("dropdown1", windowsVbox);
        dropdown1.addOption("Option 1");
        dropdown1.addOption("Option 2");
        Listbox listbox1 = windowsFactory.createListbox("listbox1", windowsVbox);
        listbox1.addItem("Item 1");
        listbox1.addItem("Item 2");
        listbox1.setSelectedIndex(0);
        GridLayout grid1 = windowsFactory.createGridLayout("grid1", windowsVbox, 2, 2);
        grid1.addChild("button1", windowsFactory.createButton("button1", grid1, "Click Me"));
        grid1.addChild("label2", windowsFactory.createLabel("label2", grid1, "World"));

        windowsVbox.addChild("label1", label1);
        windowsVbox.addChild("textbox1", textbox1);
        windowsVbox.addChild("dropdown1", dropdown1);
        windowsVbox.addChild("listbox1", listbox1);
        windowsVbox.addChild("grid1", grid1);

        windowsVbox.draw(gc);
        XMLExporter windowsExporter = new XMLExporter();
        windowsVbox.accept(windowsExporter);
        windowsExporter.exportToFile("windows_ui.xml");

        // Switch to Mac theme
        gc.clearRect(0, 0, 400, 300); // Clear canvas
        ComponentFactory macFactory = new MacThemeFactory();
        VBoxLayout macVbox = macFactory.createVBoxLayout("mac_vbox", null);
        macVbox.setPosition(20, 20);
        macVbox.setSize(360, 260);

        label1 = macFactory.createLabel("label1", macVbox, "Hello");
        textbox1 = macFactory.createTextbox("textbox1", macVbox, "Enter text");
        dropdown1 = macFactory.createDropdown("dropdown1", macVbox);
        dropdown1.addOption("Option 1");
        dropdown1.addOption("Option 2");
        listbox1 = macFactory.createListbox("listbox1", macVbox);
        listbox1.addItem("Item 1");
        listbox1.addItem("Item 2");
        listbox1.setSelectedIndex(0);
        grid1 = macFactory.createGridLayout("grid1", macVbox, 2, 2);
        grid1.addChild("button1", macFactory.createButton("button1", grid1, "Click Me"));
        grid1.addChild("label2", macFactory.createLabel("label2", grid1, "World"));

        macVbox.addChild("label1", label1);
        macVbox.addChild("textbox1", textbox1);
        macVbox.addChild("dropdown1", dropdown1);
        macVbox.addChild("listbox1", listbox1);
        macVbox.addChild("grid1", grid1);

        macVbox.draw(gc);
        XMLExporter macExporter = new XMLExporter();
        macVbox.accept(macExporter);
        macExporter.exportToFile("mac_ui.xml");

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