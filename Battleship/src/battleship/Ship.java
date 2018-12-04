/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author matt
 */
public class Ship {
    int length;
    Coordinate headCoordinate;
    Coordinate tailCoordinate;
    Coordinate [] body;
    String orientation;
    int hitCount = 0;
    
    
    public boolean isSunk(Ship ship){
        return ship.hitCount == ship.length;
    }
    
    public void setLength(int length){
        this.length = length;
    }
    
    public void setOrientation(String orientation){
        this.orientation = orientation;
    }
    
    public void setHeadCoordinateCol(Coordinate coordinate){
        headCoordinate.xAxis = coordinate.xAxis;
    }
    
    public void setHeadCoordinateRow(Coordinate coordinate){
        headCoordinate.xAxis = coordinate.xAxis;
    }
    
    public void setTailCoordinateCol(Coordinate coordinate){
        headCoordinate.xAxis = coordinate.xAxis;
    }
    
    public void setTailCoordinateRow(Coordinate coordinate){
        headCoordinate.xAxis = coordinate.xAxis;
    }
    
}
