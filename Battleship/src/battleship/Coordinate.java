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
public class Coordinate {
    public int yAxis;
    public int xAxis;
   // Coordinate head;
   // Coordinate tail;
    Boolean filled = false;
    
    public Coordinate() {
        yAxis = -1;
        xAxis = -1;
    }

    
    // row
    public void setYAxis(int value){
        yAxis = value;
    }
    
    // col
    public void setXAxis(int value){
        xAxis = value;
    }
    
}


