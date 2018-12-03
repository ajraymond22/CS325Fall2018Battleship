/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

import java.util.Scanner;

/**
 *
 * @author redbi
 */
public class Battleship extends Application {

    public static int player1Hits = 0;
    public static int player2Hits = 0;
    @Override
    public void start(Stage primaryStage) {

        Label oceanGridLabel = new Label("Ocean Grid");
        oceanGridLabel.setAlignment(Pos.CENTER);
        oceanGridLabel.setStyle("-fx-pref-height: 10px");

        Label targetGridLabel = new Label("Target Grid");
        targetGridLabel.setAlignment(Pos.CENTER);
        targetGridLabel.setStyle("-fx-pref-height: 10px");

        GameBoard player1_ocean = new GameBoard("player");
        GameBoard player1_target = new GameBoard("enemy");

        GameBoard player2_ocean = new GameBoard("player");
        GameBoard player2_target = new GameBoard("enemy");

        VBox oceanBox = new VBox();
        oceanBox.getChildren().add(oceanGridLabel);
        oceanBox.getChildren().add(player1_ocean);

        VBox targetBox = new VBox();
        targetBox.getChildren().add(targetGridLabel);
        targetBox.getChildren().add(player1_target);

        HBox root = new HBox();
        root.getChildren().add(oceanBox);

        root.getChildren().add(targetBox);

        Scene scene = new Scene(root, 480, 280);

        primaryStage.setTitle("Battleship");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void detectWin(){
        if (player1Hits == 14) {
            //POPUP saying "PLAYER 1 WINS!"
        }
        else if (player2Hits == 14){
            //POPUP saying "PLAYER 2 WINS!"
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
        
    }

}
