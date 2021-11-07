package App.GUI.components;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MoneyBox extends VBox {
    private int size;
    private int selectedIndex;

    public MoneyBox() {
        this(15);
    }

    public MoneyBox(int size) {
        this.size = size;
        this.selectedIndex = size - 1;
        for (int i = size - 1; i >= 0; --i) {
            var label = new Label(String.format("%s", (int) Math.pow(2, i)));
            label.getStyleClass().add("moneyBoxLabel");
            setSpacing(10);

            this.getChildren().add(label);
        }

        selectNth(selectedIndex);
        getStyleClass().add("moneyBox");
    }

    public void selectNth(int n) {
        if (n >= size) {
            throw new IllegalArgumentException(" N is bigger than size");
        }

        getChildren().get(n).getStyleClass().add("moneyBoxLabel_selected");
    }

    public void deselectNth(int n) {
        if (n >= size) {
            throw new IllegalArgumentException(" N is bigger than size");
        }

        getChildren().get(n).getStyleClass().removeIf("moneyBoxLabel_selected"::equals);
    }

    public void selectNext() {
        if (selectedIndex == 0) {
            throw new IllegalStateException("cant do dat");
        }

        deselectNth(selectedIndex);
        --selectedIndex;
        selectNth(selectedIndex);
    }
}
