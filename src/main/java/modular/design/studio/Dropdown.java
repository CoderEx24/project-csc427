package modular.design.studio;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Dropdown implements UIComponent {
    private final Style style;
    private Integer canvasId;
    private String selectedOption = "Option 1";
    private final String[] options = {"Option 1", "Option 2", "Option 3"};

    public Dropdown(Style style) {
        this.style = style;
    }

    public String getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String option) {
        this.selectedOption = option;
    }

    public String[] getOptions() {
        return options;
    }

    @Override
    public UIComponent clone() {
        Dropdown newDropdown = new Dropdown(style);
        newDropdown.setSelectedOption(selectedOption);
        return newDropdown;
    }

    @Override
    public void render(Pane pane, double x, double y, Integer parentId, ModularDesignStudio app) {
        Rectangle rect = new Rectangle(x, y, 100, 30);
        rect.setFill(javafx.scene.paint.Color.web(style.getColor()));
        rect.setStroke(javafx.scene.paint.Color.BLACK);
        Text text = new Text(x + 50, y + 15, selectedOption);
        text.setFont(new javafx.scene.text.Font(style.getFont(), style.getSize()));
        pane.getChildren().addAll(rect, text);
        this.canvasId = rect.hashCode();
        app.registerDropdown(rect, this);
        app.registerDraggable(rect, parentId);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Style getStyle() {
        return style;
    }
}