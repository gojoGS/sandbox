package App.GUI.components;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MoneyBox extends VBox {
    public MoneyBox() {
        this(15);
    }

    public MoneyBox(int size) {
        for (int i = 0; i < size; ++i) {
            var label = new Label("asd");
            label.setStyle("-fx-background-color: aliceblue");
            setSpacing(10);

            this.getChildren().add(label);
        }
    }
}
