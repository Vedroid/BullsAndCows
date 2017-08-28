package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {
    public Button buttHelp;
    public Button buttExit;
    public TextField inText;
    public Button buttEnter;
    public TextArea textNum;
    public TextArea textGuess;
    public TextArea textRes;

    private Game game = null;

    private String sNum = "";
    private String sGuess = "";
    private String sRes = "";
    private boolean newGame = true;

    public void onClickNewGame(ActionEvent actionEvent) {
        newGame();
    }

    public void onClickHelp(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Help");
        alert.setHeaderText(null);
        alert.setContentText("Суть игры: загадано 4-значное число, состоящее из неповторяющихся цифр.\n" +
                "Ваша задача - угадать его за ограниченное число ходов.\n" +
                "В качестве подсказок выступают “коровы”\n" +
                "(цифра угадана, но её позиция - нет)\n" +
                "и “быки” (когда совпадает и цифра и её позиция).\n" +
                "Если загадано число “1234”, а вы называете “6531”, то\n" +
                "результатом будет 1 корова (цифра “1”) и 1 бык (цифра “3”)."
        );
        alert.showAndWait();
    }

    public void onClickExit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void onKeyPeressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            enter();
        }
    }

    public void onClickEnter(ActionEvent actionEvent) {
        enter();
    }

    private void enter() {
        String in = inText.getText();
        inText.clear();
        if (newGame) {
            game = new Game();
            newGame = false;
        }
        game.start(in);

        sNum += game.getNum() + "\n";
        sGuess += in + "\n";
        if (game.getRes().equals("win")) {
            newGame();
        } else {
            sRes += game.getRes() + "\n";
        }

        textNum.setText(sNum);
        textGuess.setText(sGuess);
        textRes.setText(sRes);
    }

    private void newGame() {
        newGame = true;
        textNum.clear();
        textGuess.clear();
        textRes.clear();
        sNum = "";
        sGuess = "";
        sRes = "";
    }
}