/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import javafx.scene.Parent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author redbi
 */
public class GameBoard extends Parent{
    private String whoseBoard = "player";
    private VBox rowContainer = new VBox();
    
    public GameBoard(String whoseBoard){
        this.whoseBoard = whoseBoard;
        for (int i = 0; i < 10; i++) {
            HBox row = new HBox();
            for (int j = 0; j < 10; j++) {
                Cell c1 = new Cell(j, i, this);
                row.getChildren().add(c1);
            }
            rowContainer.getChildren().add(row);
        }
        getChildren().add(rowContainer);
    }
    
//    public boolean placeShip(Ship s1, char row, int column){
//        
//    }
    
    public Cell getCell(int x, int y){
        return (Cell)((HBox)rowContainer.getChildren().get(y)).getChildren().get(x);
    }
    public class Cell extends Rectangle{
        public int horizontalPosition;
        public int verticalPosition;
        public boolean shotAt = false;
        public GameBoard gb1;
        
        public Cell(int hp, int vp, GameBoard board){
            super(20,20);
            horizontalPosition = hp;
            verticalPosition = vp;
            gb1 = board;
            if (gb1.whoseBoard == "enemy") {
                setFill(Color.BURLYWOOD);
                setStroke(Color.BLACK);
            } else {
                setFill(Color.BLUE);
                setStroke(Color.BLACK);
            }
        }
    }
}
