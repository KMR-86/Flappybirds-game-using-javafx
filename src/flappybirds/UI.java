/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybirds;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 *
 * @author DELL
 */

public class UI {

    Image image = Config.image_bg;
    ImageView imageView = new ImageView(image);
    Button buttonNewgame = new Button();
    Button buttonHighscore = new Button();
    Button buttonInstruction = new Button();
    Button buttonCredits = new Button();

    public UI(Scene scene, Pane root) {
        buttonSetup(buttonNewgame, 360, 200, 200, 60,"NewGame");
        buttonSetup(buttonHighscore, 360, 300, 200, 60,"HighScore");
        buttonSetup(buttonInstruction, 360, 400, 200, 60,"Instructions");
        buttonSetup(buttonCredits, 360, 500, 200, 60,"Credits");
        imageView.setFitHeight(Config.SCREEN_HEIGHT);
        imageView.setFitWidth(Config.SCREEN_WIDTH);
        root.getChildren().add(imageView);
        root.getChildren().addAll(buttonCredits,buttonHighscore,buttonInstruction,buttonNewgame);
        //Creating the mouse event handler 
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                System.out.println("newgame");
                GamePlay game=new GamePlay(scene, root);
                
            }
        };
//Adding event Filter 
        buttonNewgame.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        scene.getStylesheets().add(FlappyBirds.class.getResource("css.css").toExternalForm());

    }
    static void buttonSetup(Button b,int posx,int posy,int sizeX,int sizeY,String s){
        b.setLayoutX(posx);
        b.setLayoutY(posy);
        b.setPrefSize(sizeX, sizeY);
        
        b.setText(s);
    }
}
