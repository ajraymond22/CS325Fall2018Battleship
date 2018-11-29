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
import javafx.scene.layout.GridPane;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.text.TextAlignment;
import javafx.geometry.Pos;

/**
 *
 * @author redbi
 */
public class GameBoard extends Parent {
    private static final int GRID_LENGTH = 10;
    private static final int CELL_LENGTH = 20;

    private static final Color COLOR_OCEAN_UNOCCUPIED = Color.BLUE;
    private static final Color COLOR_OCEAN_SHIP = Color.BLUE;
    private static final Color COLOR_OCEAN_HIT = Color.RED;
    private static final Color COLOR_OCEAN_SUNK = Color.MAROON;

    private static final Color COLOR_TARGET_NOTFIREDAT = Color.BURLYWOOD;
    private static final Color COLOR_TARGET_MISS = Color.CADETBLUE;
    private static final Color COLOR_TARGET_HIT = Color.RED;
    private static final Color COLOR_TARGET_SUNK = Color.MAROON;

    private static final Color COLOR_GRIDCELLBORDER = Color.BLACK;

    private String whoseBoard = "player";
    private GridPane grid = new GridPane();

    public GameBoard(String whoseBoard){
        this.whoseBoard = whoseBoard;

        int y = 0;

        // Top labels
        for (int x = 1; x <= GRID_LENGTH; x++) {
            Label l = new Label(Integer.toString(x));
            l.setStyle(String.format("-fx-pref-width: %1$dpx; -fx-pref-height: %1$dpx;",
                    CELL_LENGTH));
            l.setAlignment(Pos.CENTER);
            grid.add(l, x, y);
        }

        y++;

        for (; y <= GRID_LENGTH; y++) {
            HBox row = new HBox();
            for (int x = 0; x <= GRID_LENGTH; x++) {

                // Side label
                if (x == 0) {
                    Label l = new Label(Character.toString((char) ('A' + y - 1)));
                    l.setStyle(String.format("-fx-pref-width: %1$dpx; -fx-pref-height: %1$dpx;",
                        CELL_LENGTH));
                    l.setAlignment(Pos.CENTER);

                    grid.add(l, x, y);
                    continue;
                }

                Cell c1 = new Cell(y, x, this);
                grid.add(c1, x, y);
            }
        }
        getChildren().add(grid);
    }

//    public boolean placeShip(Ship s1, char row, int column){
//        
//    }

    public Cell getCell(int x, int y){
        //return (Cell)((HBox)rowContainer.getChildren().get(y)).getChildren().get(x);

        // https://stackoverflow.com/a/20656861
        for (Node node : grid.getChildren()) {
            if (GridPane.getColumnIndex(node) == x
                    && GridPane.getRowIndex(node) == y
                    && node instanceof Cell) {
                return (Cell) node;
            }
        }

        return null;
    }

    public class Cell extends Rectangle{

        public int horizontalPosition;
        public int verticalPosition;
        public boolean shotAt = false;
        public GameBoard gb1;

        public Cell(int hp, int vp, GameBoard board){
            super(CELL_LENGTH, CELL_LENGTH);
            horizontalPosition = hp;
            verticalPosition = vp;
            gb1 = board;
            if (gb1.whoseBoard.equals("enemy")) {
                setFill(COLOR_TARGET_NOTFIREDAT);
                setStroke(COLOR_GRIDCELLBORDER);
            } else {
                setFill(COLOR_OCEAN_UNOCCUPIED);
                setStroke(COLOR_GRIDCELLBORDER);
            }
        }
    }
}
