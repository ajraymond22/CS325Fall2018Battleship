/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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


public class InputBoard extends Application {
    
    Stage window;
    // checking coordinates to see if they intersect
    
    public Boolean checkShipCoordinates(Ship [] ships) {
        for (int i = 0; i < 5; i++) {
            
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        launch(args);
        
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        window = primaryStage;
        window.setTitle("SHIP PLACEMENT");
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        
        // Size 5 ship
        Label headLabel1 = new Label("Head coordinate of Size 5 Ship ");
        GridPane.setConstraints(headLabel1, 0, 0);
        
        TextField headInputRow1 = new TextField();
        headInputRow1.setPromptText("Row A-K");
        GridPane.setConstraints(headInputRow1, 0, 1);
        
        TextField headInputCol1 = new TextField();
        headInputRow1.setPromptText("Col 1-9");
        GridPane.setConstraints(headInputCol1, 0, 2);
        
        Label tailLabel1 = new Label("Tail coordinate of Size 5 Ship");
        GridPane.setConstraints(tailLabel1, 1, 0);
        
        TextField tailInputRow1 = new TextField();
        tailInputRow1.setPromptText("Row A-K");
        GridPane.setConstraints(tailInputRow1, 1, 1);
        
        TextField tailInputCol1 = new TextField();
        tailInputCol1.setPromptText("Col 1-9");
        GridPane.setConstraints(tailInputCol1, 1, 2);
        
        // Size 4 ship
        Label headLabel2 = new Label("Head coordinate of Size 4 Ship ");
        GridPane.setConstraints(headLabel2, 2, 0);
        
        TextField headInputRow2 = new TextField();
        headInputRow1.setPromptText("Row A-K");
        GridPane.setConstraints(headInputRow2, 2, 1);
        
        TextField headInputCol2 = new TextField();
        headInputRow1.setPromptText("Col 1-9");
        GridPane.setConstraints(headInputCol2, 2, 2);
        
        Label tailLabel2 = new Label("Tail coordinate of Size 5 Ship");
        GridPane.setConstraints(tailLabel2, 3, 0);
        
        TextField tailInputRow2 = new TextField();
        tailInputRow1.setPromptText("Row A-K");
        GridPane.setConstraints(tailInputRow2, 3, 1);
        
        TextField tailInputCol2 = new TextField();
        tailInputCol1.setPromptText("Col 1-9");
        GridPane.setConstraints(tailInputCol2, 3, 2);
        
        // Size 3 ship
        Label headLabel3 = new Label("Head coordinate of Size 4 Ship ");
        GridPane.setConstraints(headLabel3, 4, 0);
        
        TextField headInputRow3 = new TextField();
        headInputRow1.setPromptText("Row A-K");
        GridPane.setConstraints(headInputRow3, 4, 1);
        
        TextField headInputCol3 = new TextField();
        headInputRow1.setPromptText("Col 1-9");
        GridPane.setConstraints(headInputCol3, 4, 2);
        
        Label tailLabel3 = new Label("Tail coordinate of Size 5 Ship");
        GridPane.setConstraints(tailLabel3, 5, 0);
        
        TextField tailInputRow3 = new TextField();
        tailInputRow1.setPromptText("Row A-K");
        GridPane.setConstraints(tailInputRow3, 5, 1);
        
        TextField tailInputCol3 = new TextField();
        tailInputCol1.setPromptText("Col 1-9");
        GridPane.setConstraints(tailInputCol3, 5, 2);
        
        // Size 3 ship
        Label headLabel4 = new Label("Head coordinate of Size 4 Ship ");
        GridPane.setConstraints(headLabel4, 6, 0);
        
        TextField headInputRow4 = new TextField();
        headInputRow1.setPromptText("Row A-K");
        GridPane.setConstraints(headInputRow4, 6, 1);
        
        TextField headInputCol4 = new TextField();
        headInputRow1.setPromptText("Col 1-9");
        GridPane.setConstraints(headInputCol4, 6, 2);
        
        Label tailLabel4 = new Label("Tail coordinate of Size 5 Ship");
        GridPane.setConstraints(tailLabel4, 7, 0);
        
        TextField tailInputRow4 = new TextField();
        tailInputRow1.setPromptText("Row A-K");
        GridPane.setConstraints(tailInputRow4, 7, 1);
        
        TextField tailInputCol4 = new TextField();
        tailInputCol1.setPromptText("Col 1-9");
        GridPane.setConstraints(tailInputCol4, 7, 2);
        
        // Size 2 ship
        Label headLabel5 = new Label("Head coordinate of Size 4 Ship ");
        GridPane.setConstraints(headLabel5, 8, 0);
        
        TextField headInputRow5 = new TextField();
        headInputRow1.setPromptText("Row A-K");
        GridPane.setConstraints(headInputRow5, 8, 1);
        
        TextField headInputCol5 = new TextField();
        headInputRow1.setPromptText("Col 1-9");
        GridPane.setConstraints(headInputCol5, 8, 2);
        
        Label tailLabel5 = new Label("Tail coordinate of Size 5 Ship");
        GridPane.setConstraints(tailLabel5, 9, 0);
        
        TextField tailInputRow5 = new TextField();
        tailInputRow1.setPromptText("Row A-K");
        GridPane.setConstraints(tailInputRow5, 9, 1);
        
        TextField tailInputCol5 = new TextField();
        tailInputCol1.setPromptText("Col 1-9");
        GridPane.setConstraints(tailInputCol5, 9, 2);
        
        // Place Button
        Button placeButton = new Button("PLACE");
        GridPane.setConstraints(placeButton, 10, 1);
        
        grid.getChildren().addAll(headLabel1, headInputRow1, headInputCol1,
                                  tailLabel1, tailInputRow1, tailInputCol1,
                                  headLabel2, headInputRow2, headInputCol2,
                                  tailLabel2, tailInputRow2, tailInputCol2,
                                  headLabel3, headInputRow3, headInputCol3,
                                  tailLabel3, tailInputRow3, tailInputCol3,
                                  headLabel4, headInputRow4, headInputCol4,
                                  tailLabel4, tailInputRow4, tailInputCol4,
                                  headLabel5, headInputRow5, headInputCol5,
                                  tailLabel5, tailInputRow5, tailInputCol5,
                                  placeButton);
        
        Scene scene = new Scene(grid, 300, 200);
        window.setScene(scene);
        
        placeButton.setOnAction( new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                for (int i = 0; i < 5; i++) {
                    //setting ships
                }
            }
        });
        
        
        
        
    }
    
    
    
    
}
