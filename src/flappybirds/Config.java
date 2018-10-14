/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybirds;

import javafx.scene.image.Image;

/**
 *
 * @author DELL
 */
public class Config {

    public static int SCREEN_WIDTH = 960;
    public static int SCREEN_HEIGHT = 720;
    public static Image image_Bird = new Image(FlappyBirds.class.getResourceAsStream("/images/bird3.png"));
    public static Image image_piller = new Image(FlappyBirds.class.getResourceAsStream("/images/pillar.png"));
    public static Image image_bg = new Image(FlappyBirds.class.getResourceAsStream("/images/bg.png"));    
    public static boolean GameFlag=true;
    public static int score=0;
}
