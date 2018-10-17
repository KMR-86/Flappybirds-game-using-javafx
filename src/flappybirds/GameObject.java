/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flappybirds;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 *
 * @author DELL
 */
public class GameObject {
    static UI ui;
    static GamePlay gamePlay;

    public GameObject(Scene scene,Pane root) {
        ui=new UI(scene, root);
        gamePlay=new GamePlay(scene, root);
        ui.loadUI(scene, root);
        
    }
    
    
}
