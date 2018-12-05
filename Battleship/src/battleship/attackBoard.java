/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author matt
 */
public class attackBoard  {
    
    Stage attackWindowStage;
    
    
    public void start(Stage primaryStage) throws Exception{
        
        attackWindowStage = primaryStage;
        attackWindowStage.setTitle("ATTACK");
        
        GridPane attackGrid = new GridPane();
        attackGrid.setPadding(new Insets(10, 10, 10, 10));
        attackGrid.setVgap(8);
        attackGrid.setHgap(10);
        
        Label fire = new Label("Fire at this location: ");
        GridPane.setConstraints(fire, 0, 0);
        
        TextField fireInputRow = new TextField();
        fireInputRow.setPromptText("Row A-J");
        GridPane.setConstraints(fireInputRow, 0, 1);
        
        TextField fireInputCol = new TextField();
        fireInputCol.setPromptText("Col 1-10");
        GridPane.setConstraints(fireInputCol, 0, 2);
        
        Button fireButton = new Button("FIRE!");
        GridPane.setConstraints(fireButton, 2, 1);
                
        attackGrid.getChildren().addAll(fire, fireInputRow, fireInputCol, fireButton);
        
        Scene scene = new Scene(attackGrid, 300, 200);
        attackWindowStage.setScene(scene);
        attackWindowStage.show();
        
    }
}
