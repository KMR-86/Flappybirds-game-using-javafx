/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybirds;

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
public class BackGround {

    Image image = Config.image_bg;
    ImageView imageView = new ImageView(image);

    Image image2 = Config.image_bg;
    ImageView imageView2 = new ImageView(image2);

    public static Timeline BackGroundLoop;

    public BackGround(Scene scene, Pane root) {
        BackGroundLoop = new Timeline(new KeyFrame(Duration.millis(3), new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent t) {
                if (Config.GameFlag == true) {

                    if (imageView.getX() > -955) {
                        imageView.setX(imageView.getX() - 1);
                    } else {
                        imageView.setX(960);

                    }
                    if (imageView2.getX() > -955) {
                        imageView2.setX(imageView2.getX() - 1);
                    } else {
                        imageView2.setX(960);

                    }
                    //System.out.println("x1 : " + imageView.getX());
                    //System.out.println("x2 : " + imageView2.getX());
                }
            }
        }));

    }

    void init(Scene scene, Pane root) {
        imageView.setFitHeight(Config.SCREEN_HEIGHT);
        imageView.setFitWidth(Config.SCREEN_WIDTH);
        imageView2.setFitHeight(Config.SCREEN_HEIGHT);
        imageView2.setFitWidth(Config.SCREEN_WIDTH);
        imageView.setX(0);
        imageView.setY(0);
        imageView2.setX(960);
        imageView2.setY(0);

        root.getChildren().add(imageView);
        root.getChildren().add(imageView2);
        BackGroundLoop.setCycleCount(Timeline.INDEFINITE);
        BackGroundLoop.play();
    }
}
