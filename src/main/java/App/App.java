package App;

import com.sun.javafx.css.StyleManager;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public static BooleanProperty isNightThemeProperty = new SimpleBooleanProperty(false);

    private static void loadTheme() {
        var windows = Window.getWindows();

        for(var window : windows) {
            var scene = window.getScene();

            scene.getStylesheets().clear();
            scene.getStylesheets().add(App.class.getClassLoader().getResource("FXML/CSS/style.css").toExternalForm());

            if(isNightTheme.get()) {
                scene.getStylesheets().add(App.class.getClassLoader().getResource("FXML/CSS/night_style.css").toExternalForm());
            } else {
                scene.getStylesheets().add(App.class.getClassLoader().getResource("FXML/CSS/light_style.css").toExternalForm());
            }
        }
    }

    public static void switchTheme() {
        isNightTheme.set(!isNightTheme.get());
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/layout.fxml"));
        Scene scene = new Scene(root, 1920, 1080);

        isNightTheme.addListener(e -> loadTheme());

        primaryStage.setScene(scene);
        primaryStage.show();
        loadTheme();
    }
}
