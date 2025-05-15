package project.csc427.core;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MacThemeFactory implements ComponentFactory {
    @Override
    public Label createLabel(String name, Component parent, String text) {
        Label label = new Label(name, parent, text) {
            @Override
            public boolean draw(GraphicsContext gc) {
                float[] position = getPosition();
                gc.setFill(Color.BLACK); // Mac: black text
                gc.setFont(new Font("Helvetica Neue", 13)); // Mac font
                gc.fillText(getText(), position[0], position[1]);
                return true;
            }
        };
        label.setSize(60, 20);
        return label;
    }

    @Override
    public Textbox createTextbox(String name, Component parent, String text) {
        Textbox textbox = new Textbox(name, parent, text) {
            @Override
            public boolean draw(GraphicsContext gc) {
                float[] position = getPosition();
                float[] size = getSize();
                gc.setFill(Color.WHITE); // Mac: white background
                gc.fillRoundRect(position[0], position[1], size[0], size[1], 8, 8); // Rounded corners
                gc.setStroke(Color.LIGHTGRAY); // Mac: light gray border
                gc.strokeRoundRect(position[0], position[1], size[0], size[1], 8, 8);
                gc.setFill(Color.BLACK);
                gc.setFont(new Font("Helvetica Neue", 13));
                gc.fillText(getText(), position[0] + 5, position[1] + size[1] - 5);
                return true;
            }
        };
        textbox.setSize(120, 24);
        return textbox;
    }

    @Override
    public Button createButton(String name, Component parent, String text) {
        Button button = new Button(name, parent, text) {
            @Override
            public boolean draw(GraphicsContext gc) {
                float[] position = getPosition();
                float[] size = getSize();
                gc.setFill(Color.rgb(240, 240, 240)); // Mac: light button
                gc.fillRoundRect(position[0], position[1], size[0], size[1], 12, 12); // Rounded
                gc.setStroke(Color.LIGHTGRAY);
                gc.strokeRoundRect(position[0], position[1], size[0], size[1], 12, 12);
                gc.setFill(Color.BLACK);
                gc.setFont(new Font("Helvetica Neue", 14));
                double textWidth = gc.getFont().getSize() * getText().length() * 0.6;
                double textX = position[0] + (size[0] - textWidth) / 2;
                double textY = position[1] + (size[1] + gc.getFont().getSize() / 2) / 2;
                gc.fillText(getText(), textX, textY);
                return true;
            }
        };
        button.setSize(100, 32);
        return button;
    }

    @Override
    public Dropdown createDropdown(String name, Component parent) {
        Dropdown dropdown = new Dropdown(name, parent) {
            @Override
            public boolean draw(GraphicsContext gc) {
                float[] position = getPosition();
                float[] size = getSize();
                gc.setFill(Color.WHITE); // Mac: white background
                gc.fillRoundRect(position[0], position[1], size[0], size[1], 8, 8);
                gc.setStroke(Color.LIGHTGRAY);
                gc.strokeRoundRect(position[0], position[1], size[0], size[1], 8, 8);
                gc.setFill(Color.BLACK);
                gc.setFont(new Font("Helvetica Neue", 13));
                String v = options.peek();
                if (v != null) {
                    gc.fillText(v, position[0] + 5, position[1] + size[1] - 5);
                }
                gc.fillRoundRect(position[0] + size[0] - 20, position[1] + 2, 16, 16, 4, 4);
                gc.setFill(Color.BLACK);
                gc.fillText("▼", position[0] + size[0] - 16, position[1] + size[1] - 5);
                return true;
            }
        };
        dropdown.setSize(120, 24);
        return dropdown;
    }

    @Override
    public Listbox createListbox(String name, Component parent) {
        Listbox listbox = new Listbox(name, parent) {
            @Override
            public boolean draw(GraphicsContext gc) {
                float[] pos = getPosition();
                float[] size = getSize();
                double x = pos[0], y = pos[1], width = size[0], height = size[1];
                gc.setFill(Color.WHITE); // Mac: white background
                gc.fillRoundRect(x, y, width, height, 8, 8);
                gc.setStroke(Color.LIGHTGRAY);
                gc.strokeRoundRect(x, y, width, height, 8, 8);
                double itemHeight = 20;
                gc.setFont(new Font("Helvetica Neue", 13));
                for (int i = 0; i < getItems().size(); i++) {
                    if (i == getSelectedIndex()) {
                        gc.setFill(Color.rgb(200, 220, 255)); // Mac: blue selection
                        gc.fillRect(x, y + i * itemHeight, width, itemHeight);
                        gc.setFill(Color.BLACK);
                    } else {
                        gc.setFill(Color.BLACK);
                    }
                    gc.fillText(getItems().get(i), x + 5, y + (i + 1) * itemHeight - 5);
                }
                return true;
            }
        };
        listbox.setSize(120, 80);
        return listbox;
    }

    @Override
    public HBoxLayout createHBoxLayout(String name, Component parent) {
        HBoxLayout hbox = new HBoxLayout(name, parent);
        hbox.setSize(200, 50);
        return hbox;
    }

    @Override
    public VBoxLayout createVBoxLayout(String name, Component parent) {
        VBoxLayout vbox = new VBoxLayout(name, parent);
        vbox.setSize(200, 100);
        return vbox;
    }

    @Override
    public GridLayout createGridLayout(String name, Component parent, int rows, int columns) {
        GridLayout grid = new GridLayout(name, parent);
        grid.setRows(rows);
        grid.setColumns(columns);
        grid.setSize(200, 200);
        return grid;
    }
}