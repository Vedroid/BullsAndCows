package sample;

import javafx.scene.control.Alert;

import java.util.HashSet;
import java.util.Random;

class Game {
    private static Character[] ch;
    private static int level = 4;
    private String sRes = "";
    private boolean firstRun = true;
    private int h = 0;

    public Game() {
        firstRun = true;
    }

    void start(String text) {
        int cows = 0;
        int bulls = 0;
        try {
            if (firstRun) {
                //level = Integer.parseInt(reader.readLine().charAt(0) + "");
                if (level < 1 || level > 9) throw new NumberFormatException();
                genChArr();
                firstRun = false;
                //System.out.println("Вводите " + level + "-значные числа.");
            }

            if (text.length() < level || text.length() > level) throw new NumberFormatException();
            Integer.parseInt(text);

            for (int i = 0; i < level; i++) {
                if (ch[i] == text.charAt(i)) {
                    bulls++;
                } else {
                    for (int j = 0; j < level; j++) {
                        if (ch[i] == text.charAt(j)) {
                            cows++;
                        }
                    }
                }
            }
            sRes = ("Быков: " + bulls + ". Коров: " + cows + ".");
            h++;
            if (bulls == level) win();
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
            err("Введите корректное число!");
            sRes = "";
        }
    }

    private void win() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Win!");
        alert.setHeaderText(null);
        alert.setContentText("Вы вииграли за " + h + " ходов.");
        alert.showAndWait();
        sRes = "win";
    }

    private void err(String s) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(s);
        alert.showAndWait();
    }

    private void genChArr() {
        HashSet<Character> charHashSet = new HashSet<>();

        String alphabet = "0123456789";
        int n = alphabet.length();

        Random r = new Random();

        while (charHashSet.size() < level) {
            charHashSet.add(alphabet.charAt(r.nextInt(n)));
        }

        ch = charHashSet.toArray(new Character[charHashSet.size()]);

        System.out.print("Game ::: genChArr( ");
        for (char aN : ch) {
            System.out.print(aN);
        }
        System.out.println(" )");
    }

    int getNum() {
        return h;
    }

    String getRes() {
        return sRes;
    }
}
