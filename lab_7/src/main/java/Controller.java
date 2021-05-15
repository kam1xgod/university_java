import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public TextField lowestNumber;
    public TextField highestNumber;
    public TextArea textArea;
    public Button startButton;
    public Button lowerButton;
    public Button higherButton;
    public Button correctButton;
    public RadioButton darkThemeButton;
    public RadioButton mintThemeButton;
    public RadioButton defaultThemeButton;
    public HBox mainHBOX;
    public ImageView imageOnWin;
    private int higherLimit;
    private int lowerLimit;
    private int randomizedNumber;
    private int prevNumber;
    private int pos = 0;
    private boolean isGameStarted = false;
    private Random rand;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textArea.setText("Select lowest and highest number. Then click start and let's play!");
        pos = textArea.getLength();
        lowerButton.setDisable(true);
        higherButton.setDisable(true);
        correctButton.setDisable(true);
        ToggleGroup tg = new ToggleGroup();
        defaultThemeButton.setToggleGroup(tg);
        darkThemeButton.setToggleGroup(tg);
        mintThemeButton.setToggleGroup(tg);
        defaultThemeButton.setSelected(true);
    }

    public void startButtonAction(ActionEvent actionEvent) throws NullPointerException {
        //todo: write code for actual game;
        if (!isGameStarted) {
            isGameStarted = true;
            try {
                higherLimit = Integer.parseInt(highestNumber.getText());
                lowerLimit = Integer.parseInt(lowestNumber.getText());
                if (higherLimit < lowerLimit) {
                    textArea.insertText(pos, "\nERROR: your higher limit is bigger than lower.");
                    pos = textArea.getLength();
                    isGameStarted = false;
                    return;
                }
                if (higherLimit == lowerLimit) {
                    textArea.insertText(pos, "\nDon't think i'm that stupid. Your number is: " + higherLimit*4 + "/4\n" +
                            "Now you must to count. Let's try again, but don't try to fool me.");
                    pos = textArea.getLength();
                    isGameStarted = false;
                    //todo: if you have nothing to do rn change "Start" to "I'm sorry" and if it was the first time then program returns in normal statement.
                    //todo: if not — interface just do nothing until restart.
                    return;
                }
                lowerButton.setDisable(false);
                higherButton.setDisable(false);
                correctButton.setDisable(false);
                startButton.setText("Restart");

                randomizedNumber = getNumberBetweenLimits(higherLimit, lowerLimit);
                textArea.insertText(pos, "\nYour number is... " + randomizedNumber);
                pos = textArea.getLength();
            } catch (NumberFormatException exc) {
                textArea.insertText(pos, "\nWARNING: write integer numbers in limits.");
                pos = textArea.getLength();
                isGameStarted = false;
            }
            return;
        }
        lowerButton.setDisable(true);
        higherButton.setDisable(true);
        correctButton.setDisable(true);
        startButton.setText("Start");
        isGameStarted = false;
        imageOnWin.setVisible(false);
        textArea.insertText(pos, "\nWARNING: you've restarted the game.");
        pos = textArea.getLength();
    }

    public void lowerButtonAction(ActionEvent actionEvent) {
        if (higherLimit == lowerLimit || higherLimit - lowerLimit == 1) {
            textArea.insertText(pos, "\nYou're lying! This is your number.\n" +
                                          "...Or you skipped it. I don't worry about it\n" +
                                          "I've just ran out of numbers. Let's play again.");
            pos = textArea.getLength();
            return;
        }
        if (randomizedNumber != lowerLimit) {
            prevNumber = randomizedNumber;
            higherLimit = randomizedNumber - 1;
            randomizedNumber = getNumberBetweenLimits(higherLimit, lowerLimit);
            textArea.insertText(pos, "\nYour number is... " + randomizedNumber);
            pos = textArea.getLength();
            return;
        }
        textArea.insertText(pos, "\nHey! It's the lowest limit, you can't go lower.");
        pos = textArea.getLength();
    }

    public void higherButtonAction(ActionEvent actionEvent) {
        if (higherLimit == lowerLimit) {
            textArea.insertText(pos, "\nYou're lying! This is your number.\n" +
                    "...Or you skipped it. I don't worry about it\n" +
                    "I've just ran out of numbers. Let's play again.");
            pos = textArea.getLength();
            return;
        }
        if (randomizedNumber != higherLimit) {
            prevNumber = randomizedNumber;
            lowerLimit = randomizedNumber + 1;
            randomizedNumber = getNumberBetweenLimits(higherLimit, lowerLimit);
            textArea.insertText(pos, "\nYour number is... " + randomizedNumber);
            pos = textArea.getLength();
            return;
        }
        textArea.insertText(pos, "\nHey! It's the highest limit, you can't go higher.");
        pos = textArea.getLength();
    }

    public void correctButtonAction(ActionEvent actionEvent) {
        if (randomizedNumber == 69 || randomizedNumber == 420 || randomizedNumber == 1337) {
            textArea.insertText(pos, "\nSrsly? wow, you're so funny.\n" +
                    "*laughing on machine language*");

            pos = textArea.getLength();
            lowerButton.setDisable(true);
            higherButton.setDisable(true);
            correctButton.setDisable(true);
            startButton.setText("Restart");
            return;
        }

        lowerButton.setDisable(true);
        higherButton.setDisable(true);
        correctButton.setDisable(true);
        startButton.setText("Restart");
        textArea.insertText(pos, "\nOh... Wow. haha, that was quite easy.\n" +
                "Maybe another one, huh?");
        imageOnWin.setVisible(true);
        pos = textArea.getLength();
    }

    public int getNumberBetweenLimits(int high, int low) {
        return (high + low)/2;
    }

    public void defaultThemeButtonAction(ActionEvent actionEvent) {
        mainHBOX.getScene().getStylesheets().clear();
        mainHBOX.getScene().getStylesheets().add(getClass().getResource("/default.css").toExternalForm());
    }

    public void darkThemeButtonAction(ActionEvent actionEvent) {
        mainHBOX.getScene().getStylesheets().clear();
        mainHBOX.getScene().getStylesheets().add(getClass().getResource("/dark.css").toExternalForm());
    }

    public void mintThemeButtonAction(ActionEvent actionEvent) {
        mainHBOX.getScene().getStylesheets().clear();
        mainHBOX.getScene().getStylesheets().add(getClass().getResource("/mint.css").toExternalForm());
    }
}
