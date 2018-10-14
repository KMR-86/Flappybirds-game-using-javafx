/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybirds;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 *
 * @author DELL
 */
public class Textboxes {

    public Text text;

    public Textboxes(Scene scene, Pane root, int posX, int posY, int sizeX, int sizeY, int fontSize) {
        text = new Text(posX, posY, " ");
        text.prefHeight(sizeX);
        text.prefWidth(sizeY);
        text.setStyle("-fx-font: " + fontSize + " arial;");
        text.setFill(Color.BLACK);
        root.getChildren().add(text);
    }
}
