/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybirds;

import static flappybirds.Obstacle.randomPositionFactor;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 *
 * @author DELL
 */
public class GamePlay {

    BackGround backGround;
    Bird bird;
    Obstacle obstacle;
    Textboxes textboxScore;
    Textboxes textGameMsg;
    Timeline Gameloop;
    UI ui;
    Button backButton;

    public GamePlay(Scene scene, Pane root) {

        backGround = new BackGround(scene, root);
        bird = new Bird(scene, root);
        obstacle = new Obstacle(scene, root);
        textboxScore = new Textboxes(scene, root, 700, 100, 100, 150, 46);
        textGameMsg = new Textboxes(scene, root, 360, 600, 100, 150, 46);
        ui = new UI(scene, root);
        backButton = new Button();
        UI.buttonSetup(backButton, 50, 100, 120, 50, "Back");
        if (Config.i == 4) {
            backButton.setVisible(false);
            
        }
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                System.out.println("newgame");
                ui.loadUI(scene, root);
                Config.GameFlag = true;
                obstacle.ObstacleLoop.stop();
                Gameloop.stop();
                Config.score = 0;
                ui.game = null;
                Config.i++;

            }
        };

        backButton.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

        Gameloop = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
            boolean flag = true;

            @Override
            public void handle(final ActionEvent t) {

                if (isCollision(bird.imageView, obstacle.imageViewUp) || isCollision(bird.imageView, obstacle.imageViewDown)) {
                    Config.GameFlag = false;
                    //System.out.println("1")
                    if (Config.i==4) {
                        textGameMsg.text.setText("Game Over");
                    }
                    ;

                }
                if (bird.imageView.getY() < -50 || bird.imageView.getY() > 720) {
                    Config.GameFlag = false;
                    //System.out.println("2");
                }
                if (bird.imageView.getX() > obstacle.imageViewUp.getX() && flag) {
                    flag = false;
                    Config.score++;
                    textboxScore.text.setText("SCORE : " + String.valueOf(Config.score));
                }
                if (obstacle.imageViewUp.getX() > 105) {
                    flag = true;
                }
                System.out.println(Config.GameFlag);
                //System.out.println("bird X " + bird.imageView.getX());
                //System.out.println("obstacle x " + obstacle.imageViewUp.getX());

            }
        }));


        /*scene.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode() == KeyCode.R) {
                //ui.loadUI(scene, root);
            }
        });*/
    }

    void begin(Scene scene, Pane root) {
        backGround.init(scene, root);
        bird.init(scene, root);
        textboxScore.text.setText("SCORE : 0");
        textboxScore.init(scene, root);
        textGameMsg.init(scene, root);
        obstacle.init(scene, root);
        root.getChildren().add(backButton);
        Gameloop.setCycleCount(Timeline.INDEFINITE);
        Gameloop.play();
    }

    static boolean isCollision(ImageView bird, ImageView piller) {
        if (bird.getY() < piller.getY() + 580 && bird.getY() >= piller.getY() - 30 && bird.getX() < piller.getX() + 100 && bird.getX() > piller.getX() - 30) {
            //System.out.println("bird x ="+ bird.getX() +"bird y="+ bird.getY());
            //System.out.println("piler x ="+ piller.getX() +"piller y="+ piller.getY());

            return true;
        }
        return false;
    }

}
