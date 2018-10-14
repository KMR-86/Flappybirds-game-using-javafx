/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybirds;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 *
 * @author DELL
 */
public class Bird {

    Image image = Config.image_Bird;
    ImageView imageView = new ImageView(image);
    Timeline birdJumpLoop;
    int time = 0;

    public Bird(Scene scene, Pane root) {
        imageView.setX(100);
        imageView.setY(600);
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);
        root.getChildren().add(imageView);
        birdJumpLoop = new Timeline(new KeyFrame(Duration.millis(50), new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent t) {
                if (Config.GameFlag == true) {

                    time++;
                    imageView.setY(imageView.getY() - 5 * time + .49 * time * time);
                    //System.out.println("y is " + imageView.getY());
                    if (imageView.getY() > 760) {
                        birdJumpLoop.stop();
                        imageView.setY(760);
                        time = 0;
                    }
                }

            }
        }));
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (Config.GameFlag == true) {
                    if (event.getCode() == KeyCode.J || event.getCode() == KeyCode.SPACE) {

                        time = 0;
                        if (birdJumpLoop.getStatus() == Animation.Status.STOPPED) {
                            birdJumpLoop.setCycleCount(Timeline.INDEFINITE);
                            birdJumpLoop.play();
                        }

                    }

                }
            }

        });
    }

}
