package App.GUI.controller;

import App.App;
import App.GUI.components.AnswerGrid;
import App.GUI.components.QuestionLabel;
import App.model.AnswerId;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

import java.util.HashMap;

public class LayoutController {
    @FXML
    AnswerGrid answerGrid;

    @FXML
    QuestionLabel questionLabel;

    @FXML
    BorderPane borderPane;


    int dummy = 0;

    @FXML
    public void initialize() {

        BorderPane.setMargin(questionLabel, new Insets(15));

//        setQuestion("Mi az élet értelme? Mondta józsef attila. de mégis ki gondolná, hogy nemcsak a költő szereti a nagykeblő, öblös seggű nőket?");
        setQuestion("Mi az élet értelme?");


        var ansers = new HashMap<AnswerId, String>();
        ansers.put(AnswerId.A, "csöcsök");
        ansers.put(AnswerId.B, "segg");
        ansers.put(AnswerId.C, "A és B");
        ansers.put(AnswerId.D, "C");

        answerGrid.setButtonOnActionEventHandler(this::setOnButtonClick);

        answerGrid.setAnswer(ansers);

        Button asd = new Button("theme");
        asd.setOnAction(this::setOnTheme);

        borderPane.setTop(asd);
    }

    private void setOnTheme(ActionEvent event) {
        App.isNightTheme = !App.isNightTheme;

        Scene scene = ((Node)event.getSource()).getScene();
        scene.getStylesheets().clear();

        if (App.isNightTheme) {
            scene.getStylesheets().add(getClass().getClassLoader().getResource("FXML/CSS/night_style.css").toExternalForm());
        } else {
            scene.getStylesheets().add(getClass().getClassLoader().getResource("FXML/CSS/style.css").toExternalForm());
        }
    }

    private void setOnButtonClick(ActionEvent event) {
        Button source = (Button)event.getSource();
        AnswerId id = answerGrid.getAnswerIdOfButton(source);

        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> {
            switch (dummy % 4) {
                case 0 -> answerGrid.setSelectedStyleForButton(id);
                case 1 -> answerGrid.setRightStyleForButton(id);
                case 2 -> answerGrid.setWrongStyleForButton(id);
                case 3 -> answerGrid.removeAllExtraStyle();
            }
            ++dummy;
        });

        pause.play();

    }

    private void setQuestion(String question) {
        questionLabel.setText(question);
    }
}
