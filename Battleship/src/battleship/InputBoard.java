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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author matt
 */


public class InputBoard {//extends Application {
    
    //static Stage inputBoardStage;
    Ship [] myships = new Ship[5];
    Coordinate [][] coordinates = new Coordinate[10][10];
    Boolean inBounds = true;
    Boolean formFilled = true;
    Boolean noIntersect = true;
    // global variable int myTotalHitCount = 0;
    String errorMessageOutOfBounds = "1 or more ships are out of bounds";
    String errorMessageShipsOverlap = "1 or more ships overlap";
    String errorMessageNotComplete = "Some data is missing";  
    
    
    // checking ship orientation
    public void shipOrientation(Ship ship) {
        if (ship.headCoordinate.yAxis == ship.tailCoordinate.yAxis) {
            ship.setOrientation("Horizontal");
        } else {
            ship.setOrientation("Vertical");
        }       
    }
    
    // fill body of ship coordinates
    public void fillShip(Ship ship){
        if ("Horizontal".equals(ship.orientation) && ship.length == 5) {
            ship.body[0].xAxis = ship.headCoordinate.xAxis + 1;
            ship.body[0].yAxis = ship.headCoordinate.yAxis;
            ship.body[1].xAxis = ship.body[0].xAxis + 1;
            ship.body[1].yAxis = ship.body[0].yAxis;
            ship.body[2].xAxis = ship.body[0].xAxis + 1;
            ship.body[2].yAxis = ship.body[0].yAxis;
        } else if ("Horizontal".equals(ship.orientation) && ship.length == 4) {
            ship.body[0].xAxis = ship.headCoordinate.xAxis + 1;
            ship.body[0].yAxis = ship.headCoordinate.yAxis;
            ship.body[1].xAxis = ship.body[0].xAxis + 1;
            ship.body[1].yAxis = ship.body[0].yAxis;
        } else if ("Horizontal".equals(ship.orientation) && ship.length == 3) {
            ship.body[0].xAxis = ship.headCoordinate.xAxis + 1;
            ship.body[0].yAxis = ship.headCoordinate.yAxis;
        } else if ("Vertical".equals(ship.orientation) && ship.length == 5) {
            ship.body[0].xAxis = ship.headCoordinate.xAxis;
            ship.body[0].yAxis = ship.headCoordinate.yAxis + 1;
            ship.body[1].xAxis = ship.body[0].xAxis;
            ship.body[1].yAxis = ship.body[0].yAxis + 1;
            ship.body[2].xAxis = ship.body[0].xAxis;
            ship.body[2].yAxis = ship.body[0].yAxis + 1;
        } else if ("Vertical".equals(ship.orientation) && ship.length == 4) {
            ship.body[0].xAxis = ship.headCoordinate.xAxis;
            ship.body[0].yAxis = ship.headCoordinate.yAxis + 1;
            ship.body[1].xAxis = ship.body[0].xAxis;
            ship.body[1].yAxis = ship.body[0].yAxis + 1;
        } else if ("Vertical".equals(ship.orientation) && ship.length == 4) {
            ship.body[0].xAxis = ship.headCoordinate.xAxis;
            ship.body[0].yAxis = ship.headCoordinate.yAxis + 1;
        }
    }
    
    public void fillCoordinates(Ship ship) {
        switch (ship.length) {
            case 5:
                coordinates[ship.headCoordinate.xAxis][ship.headCoordinate.yAxis].filled = true;
                coordinates[ship.body[0].xAxis][ship.body[0].yAxis].filled = true;
                coordinates[ship.body[1].xAxis][ship.body[1].yAxis].filled = true;
                coordinates[ship.body[2].xAxis][ship.body[2].yAxis].filled = true;
                coordinates[ship.tailCoordinate.xAxis][ship.tailCoordinate.yAxis].filled = true;
                break;
            case 4:
                coordinates[ship.headCoordinate.xAxis][ship.headCoordinate.yAxis].filled = true;
                coordinates[ship.body[0].xAxis][ship.body[0].yAxis].filled = true;
                coordinates[ship.body[1].xAxis][ship.body[1].yAxis].filled = true;
                coordinates[ship.tailCoordinate.xAxis][ship.tailCoordinate.yAxis].filled = true;
                break;
            case 3:
                coordinates[ship.headCoordinate.xAxis][ship.headCoordinate.yAxis].filled = true;
                coordinates[ship.body[0].xAxis][ship.body[0].yAxis].filled = true;
                coordinates[ship.tailCoordinate.xAxis][ship.tailCoordinate.yAxis].filled = true;
                break;
            case 2:
                coordinates[ship.headCoordinate.xAxis][ship.headCoordinate.yAxis].filled = true;
                coordinates[ship.tailCoordinate.xAxis][ship.tailCoordinate.yAxis].filled = true;
                break;
            default:
                break;
        }
    }
    
    public Boolean doShipsOverlap() {
        return true;
    }
    
    // make sure ships are in the grid
    public Boolean checkShipBounds (Ship ship) {
        if (ship.headCoordinate.xAxis < 0 || ship.headCoordinate.yAxis > 9) {
            return false;
        } else if (ship.tailCoordinate.xAxis < 0 || ship.tailCoordinate.yAxis > 9) {
            return false;
        }
        return true;
    }
        
//    public static void main(String[] args) {
//        launch(args);
//        
//    }
    //@Override
    public void displayInputBoard(Stage primaryStage){ //throws Exception{
        
        //Stage inputBoardStage = primaryStage;
        primaryStage.setTitle("SHIP PLACEMENT");
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        
        //int shipLengths[] = { 5, 4, 3, 3, 2};

        //TextField rowInput[shipLengths.length]
        //TextField colInput[shipLengths.length]
        
        // Size 5 ship
        Label headLabel1 = new Label("Head coordinate of Size 5 Ship ");
        GridPane.setConstraints(headLabel1, 0, 0);
        
        TextField headInputRow1 = new TextField();
        headInputRow1.setPromptText("Row A-J");
        GridPane.setConstraints(headInputRow1, 1, 0);
        
        TextField headInputCol1 = new TextField();
        headInputCol1.setPromptText("Col 1-10");
        GridPane.setConstraints(headInputCol1, 2, 0);
        
        Label tailLabel1 = new Label("Tail coordinate of Size 5 Ship");
        GridPane.setConstraints(tailLabel1, 0, 1);
        
        TextField tailInputRow1 = new TextField();
        tailInputRow1.setPromptText("Row A-J");
        GridPane.setConstraints(tailInputRow1, 1, 1);
        
        TextField tailInputCol1 = new TextField();
        tailInputCol1.setPromptText("Col 1-10");
        GridPane.setConstraints(tailInputCol1, 2, 1);
        
        // Size 4 ship
        Label headLabel2 = new Label("Head coordinate of Size 4 Ship ");
        GridPane.setConstraints(headLabel2, 0, 3);
        
        TextField headInputRow2 = new TextField();
        headInputRow1.setPromptText("Row A-J");
        GridPane.setConstraints(headInputRow2, 1, 3);
        
        TextField headInputCol2 = new TextField();
        headInputRow1.setPromptText("Col 1-10");
        GridPane.setConstraints(headInputCol2, 2, 3);
        
        Label tailLabel2 = new Label("Tail coordinate of Size 4 Ship");
        GridPane.setConstraints(tailLabel2, 0, 4);
        
        TextField tailInputRow2 = new TextField();
        tailInputRow1.setPromptText("Row A-J");
        GridPane.setConstraints(tailInputRow2, 1, 4);
        
        TextField tailInputCol2 = new TextField();
        tailInputCol1.setPromptText("Col 1-10");
        GridPane.setConstraints(tailInputCol2, 2, 4);
        
        // Size 3 ship
        Label headLabel3 = new Label("Head coordinate of Size 3 Ship ");
        GridPane.setConstraints(headLabel3, 0, 5);
        
        TextField headInputRow3 = new TextField();
        headInputRow1.setPromptText("Row A-J");
        GridPane.setConstraints(headInputRow3, 1, 5);
        
        TextField headInputCol3 = new TextField();
        headInputRow1.setPromptText("Col 1-10");
        GridPane.setConstraints(headInputCol3, 2, 5);
        
        Label tailLabel3 = new Label("Tail coordinate of Size 3 Ship");
        GridPane.setConstraints(tailLabel3, 0, 6);
        
        TextField tailInputRow3 = new TextField();
        tailInputRow1.setPromptText("Row A-J");
        GridPane.setConstraints(tailInputRow3, 1, 6);
        
        TextField tailInputCol3 = new TextField();
        tailInputCol1.setPromptText("Col 1-10");
        GridPane.setConstraints(tailInputCol3, 2, 6);
        
        // Size 3 ship
        Label headLabel4 = new Label("Head coordinate of Size 3 Ship ");
        GridPane.setConstraints(headLabel4, 0, 7);
        
        TextField headInputRow4 = new TextField();
        headInputRow1.setPromptText("Row A-J");
        GridPane.setConstraints(headInputRow4, 1, 7);
        
        TextField headInputCol4 = new TextField();
        headInputRow1.setPromptText("Col 1-10");
        GridPane.setConstraints(headInputCol4, 2, 7);
        
        Label tailLabel4 = new Label("Tail coordinate of Size 3 Ship");
        GridPane.setConstraints(tailLabel4, 0, 8);
        
        TextField tailInputRow4 = new TextField();
        tailInputRow1.setPromptText("Row A-J");
        GridPane.setConstraints(tailInputRow4, 1, 8);
        
        TextField tailInputCol4 = new TextField();
        tailInputCol1.setPromptText("Col 1-10");
        GridPane.setConstraints(tailInputCol4, 2, 8);
        
        // Size 2 ship
        Label headLabel5 = new Label("Head coordinate of Size 2 Ship ");
        GridPane.setConstraints(headLabel5, 0, 9);
        
        TextField headInputRow5 = new TextField();
        headInputRow1.setPromptText("Row A-J");
        GridPane.setConstraints(headInputRow5, 1, 9);
        
        TextField headInputCol5 = new TextField();
        headInputRow1.setPromptText("Col 1-10");
        GridPane.setConstraints(headInputCol5, 2, 9);
        
        Label tailLabel5 = new Label("Tail coordinate of Size 2 Ship");
        GridPane.setConstraints(tailLabel5, 0, 10);
        
        TextField tailInputRow5 = new TextField();
        tailInputRow1.setPromptText("Row A-J");
        GridPane.setConstraints(tailInputRow5, 1, 10);
        
        TextField tailInputCol5 = new TextField();
        tailInputCol1.setPromptText("Col 1-10");
        GridPane.setConstraints(tailInputCol5, 2, 10);
        
        // Place Button
        Button placeButton = new Button("PLACE");
        GridPane.setConstraints(placeButton, 2, 11);
        
        //Error Message out of bounds
        Alert alert1 = new Alert(AlertType.ERROR);
        alert1.setTitle("Input Validation Error");
        
        //Error Message form missing data
        Alert alert2 = new Alert(AlertType.ERROR);
        alert2.setTitle("Input Validation Error");
        
        //Error Message ships overlap
        Alert alert3 = new Alert(AlertType.ERROR);
        alert3.setTitle("Input Validation Error");
        
        
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
        
        Scene inputBoardScene = new Scene(grid, 600, 400);
        primaryStage.setScene(inputBoardScene);
        primaryStage.show();
        
        
        placeButton.setOnAction((ActionEvent e) -> {
            // setting up size 5 ship
            Ship ship5 = new Ship();
            ship5.setLength(5);
            ship5.headCoordinate.setXAxis((int) (headInputRow1.getText().charAt(0) - 'A'));
            ship5.headCoordinate.setYAxis(Integer.parseInt(headInputCol1.getText()));
            ship5.tailCoordinate.setXAxis((int) (tailInputRow1.getText().charAt(0) - 'A'));
            ship5.headCoordinate.setYAxis(Integer.parseInt(headInputCol1.getText()));
            myships[0] = ship5;
            
            if (checkShipBounds(myships[0]) == false) {
                inBounds = false;
            }
            
            // setting up size 4 ship
            Ship ship4 = new Ship();
            ship4.setLength(4);
            ship4.headCoordinate.setXAxis((int) (headInputRow2.getText().charAt(0) - 'A'));
            ship4.headCoordinate.setYAxis(Integer.parseInt(headInputCol2.getText()));
            ship4.tailCoordinate.setXAxis((int) (tailInputRow2.getText().charAt(0) - 'A'));
            ship4.headCoordinate.setYAxis(Integer.parseInt(headInputCol2.getText()));
            myships[1] = ship4;
                        
            if (checkShipBounds(myships[1]) == false) {
                inBounds = false;
            }
            
            // setting up size 3 ship
            Ship ship3 = new Ship();
            ship3.setLength(3);
            ship3.headCoordinate.setXAxis((int) (headInputRow3.getText().charAt(0) - 'A'));
            ship3.headCoordinate.setYAxis(Integer.parseInt(headInputCol3.getText()));
            ship3.tailCoordinate.setXAxis((int) (tailInputRow3.getText().charAt(0) - 'A'));
            ship3.headCoordinate.setYAxis(Integer.parseInt(headInputCol3.getText()));
            myships[2] = ship3;
                        
            if (checkShipBounds(myships[2]) == false) {
                inBounds = false;
            }
            
            // setting up size 3 ship
            Ship ship2 = new Ship();
            ship2.setLength(3);
            ship2.headCoordinate.setXAxis((int) (headInputRow4.getText().charAt(0) - 'A'));
            ship2.headCoordinate.setYAxis(Integer.parseInt(headInputCol4.getText()));
            ship2.tailCoordinate.setXAxis((int) (tailInputRow4.getText().charAt(0) - 'A'));
            ship2.headCoordinate.setYAxis(Integer.parseInt(headInputCol4.getText()));
            myships[3] = ship2;
                        
            if (checkShipBounds(myships[3]) == false) {
                inBounds = false;
            }
            
            // setting up size 2 ship
            Ship ship1 = new Ship();
            ship1.setLength(2);
            ship1.headCoordinate.setXAxis((int) (headInputRow5.getText().charAt(0) - 'A'));
            ship1.headCoordinate.setYAxis(Integer.parseInt(headInputCol5.getText()));
            ship1.tailCoordinate.setXAxis((int) (tailInputRow5.getText().charAt(0) - 'A'));
            ship1.headCoordinate.setYAxis(Integer.parseInt(headInputCol5.getText()));
            myships[4] = ship1;
                        
            if (checkShipBounds(myships[4]) == false) {
                inBounds = false;
            }
            // is the form missing data
            if (headInputRow1.getText().isEmpty() == true ||
                    headInputRow2.getText().isEmpty() == true ||
                    headInputRow3.getText().isEmpty() == true ||
                    headInputRow4.getText().isEmpty() == true ||
                    headInputRow5.getText().isEmpty() == true ||
                    headInputCol1.getText().isEmpty() == true ||
                    headInputCol2.getText().isEmpty() == true ||
                    headInputCol3.getText().isEmpty() == true ||
                    headInputCol4.getText().isEmpty() == true ||
                    headInputCol5.getText().isEmpty() == true ||
                    tailInputRow1.getText().isEmpty() == true ||
                    tailInputRow2.getText().isEmpty() == true ||
                    tailInputRow3.getText().isEmpty() == true ||
                    tailInputRow4.getText().isEmpty() == true ||
                    tailInputRow5.getText().isEmpty() == true ||
                    tailInputCol1.getText().isEmpty() == true ||
                    tailInputCol2.getText().isEmpty() == true ||
                    tailInputCol3.getText().isEmpty() == true ||
                    tailInputCol4.getText().isEmpty() == true ||
                    tailInputCol5.getText().isEmpty() == true) {
                alert2.setContentText(errorMessageNotComplete);
                alert2.showAndWait();
            }
            
            //message if error is found
            if (inBounds == false) {
                alert1.setContentText(errorMessageOutOfBounds);
                alert1.showAndWait();
            }
            // finish creating the ships
            fillShip(myships[0]);
            fillShip(myships[1]);
            fillShip(myships[2]);
            fillShip(myships[3]);
            fillShip(myships[4]);
            
            // fill in coordinates to use to fill in the grid
            fillCoordinates(myships[0]);
            fillCoordinates(myships[1]);
            fillCoordinates(myships[2]);
            fillCoordinates(myships[3]);
            fillCoordinates(myships[4]);
            
            
            if (inBounds == true && formFilled == true && noIntersect == true) {
                
            }
        });
        
    }   
}
