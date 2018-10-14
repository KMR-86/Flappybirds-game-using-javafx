/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybirds;

import static flappybirds.Obstacle.randomPositionFactor;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 *
 * @author DELL
 */
public class GamePlay {

    public GamePlay(Scene scene, Pane root) {
        BackGround backGround=new BackGround(scene, root);
        Bird bird = new Bird(scene, root);
        Obstacle obstacle = new Obstacle(scene, root);
        Textboxes textboxScore = new Textboxes(scene, root, 700, 100, 100, 150, 46);
        
        Timeline Gameloop;
        textboxScore.text.setText("SCORE : 0");
        Gameloop = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
            boolean flag = true;

            @Override
            public void handle(final ActionEvent t) {

                if (isCollision(bird.imageView, obstacle.imageViewUp) || isCollision(bird.imageView, obstacle.imageViewDown)) {
                    Config.GameFlag = false;

                }
                if (bird.imageView.getX() > obstacle.imageViewUp.getX() && flag) {
                    flag = false;
                    Config.score++;
                    textboxScore.text.setText("SCORE : " + String.valueOf(Config.score));
                }
                if (obstacle.imageViewUp.getX() > 105) {
                    flag = true;
                }
                System.out.println("bird X " + bird.imageView.getX());
                System.out.println("obstacle x " + obstacle.imageViewUp.getX());

            }
        }));
        Gameloop.setCycleCount(Timeline.INDEFINITE);
        Gameloop.play();

    }

    static boolean isCollision(ImageView bird, ImageView piller) {
        if (bird.getY() < piller.getY() + 550 && bird.getY() >= piller.getY() && bird.getX() < piller.getX() + 100 && bird.getX() > piller.getX() - 10) {
            //System.out.println("bird x ="+ bird.getX() +"bird y="+ bird.getY());
            //System.out.println("piler x ="+ piller.getX() +"piller y="+ piller.getY());

            return true;
        }
        return false;
    }

}
