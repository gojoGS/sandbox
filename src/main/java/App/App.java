package App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public static boolean isNightTheme = false;

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/layout.fxml"));
        Scene scene = new Scene(root, 720, 480);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("FXML/CSS/style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
