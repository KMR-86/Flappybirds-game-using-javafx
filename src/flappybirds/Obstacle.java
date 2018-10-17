/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybirds;

import java.util.concurrent.ThreadLocalRandom;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 *
 * @author DELL
 */
public class Obstacle {

    Image imageUp = Config.image_piller;
    Image imageDown = Config.image_piller;
    ImageView imageViewUp = new ImageView(imageUp);
    ImageView imageViewDown = new ImageView(imageDown);
    Timeline ObstacleLoop;

    public Obstacle(Scene scene, Pane root) {

        ObstacleLoop = new Timeline(new KeyFrame(Duration.millis(3), new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent t) {
                if (Config.GameFlag == true) {
                    imageViewUp.setX(imageViewUp.getX() - 1);
                    imageViewDown.setX(imageViewDown.getX() - 1);
                    if (imageViewUp.getX() < -100) {
                        imageViewUp.setX(1000);
                        imageViewDown.setX(1000);
                        int temp = randomPositionFactor();
                        imageViewUp.setY(-240 + temp);
                        imageViewDown.setY(460 + temp);

                    }
                }
            }
        }));

    }

    void init(Scene scene, Pane root) {
        imageViewUp.setX(1200);
        imageViewUp.setY(-240);
        imageViewUp.setFitHeight(600);
        imageViewUp.setFitWidth(100);
        root.getChildren().add(imageViewUp);

        imageViewDown.setX(1200);
        imageViewDown.setY(460);
        imageViewDown.setFitHeight(600);
        imageViewDown.setFitWidth(100);
        root.getChildren().add(imageViewDown);

        ObstacleLoop.setCycleCount(Timeline.INDEFINITE);
        ObstacleLoop.play();
    }

    public static int randomPositionFactor() {

        return ThreadLocalRandom.current().nextInt(-250, 250);
    }
}
