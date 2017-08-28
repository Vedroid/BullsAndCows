package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
Быки и коровы

Суть игры: ваш соперник, будь то компьютер или друг, загадывает 4-значное число, состоящее из неповторяющихся цифр.
Ваша задача - угадать его за ограниченное число ходов.
В качестве подсказок выступают “коровы” (цифра угадана, но её позиция - нет)
и “быки” (когда совпадает и цифра и её позиция). То есть если загадано число “1234”,
а вы называете “6531”, то результатом будет 1 корова (цифра “1”) и 1 бык (цифра “3”).

Чем полезно: создание игры не потребует от вас углубленного знания языка,а сам язык может быть практически любой.
При этом вам придётся использовать практически все базовые упражнения с циклами и операторами,
да и на выходе получится весьма интересная игра.

Как усложнить: сохранение результатов, круговое соревнование на несколько игроков, режим турнира, игра по сети.
*/

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Bulls and Cows");
        primaryStage.setScene(new Scene(root, 290, 400));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
